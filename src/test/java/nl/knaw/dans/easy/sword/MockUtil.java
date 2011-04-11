package nl.knaw.dans.easy.sword;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.knaw.dans.easy.business.dataset.DatasetSubmissionImpl;
import nl.knaw.dans.easy.data.Data;
import nl.knaw.dans.easy.data.userrepo.EasyUserRepo;
import nl.knaw.dans.easy.domain.dataset.DatasetImpl;
import nl.knaw.dans.easy.domain.model.Dataset;
import nl.knaw.dans.easy.domain.model.emd.types.ApplicationSpecific.MetadataFormat;
import nl.knaw.dans.easy.domain.model.user.EasyUser;
import nl.knaw.dans.easy.domain.model.user.EasyUser.Role;
import nl.knaw.dans.easy.domain.user.EasyUserImpl;
import nl.knaw.dans.easy.domain.worker.WorkListener;
import nl.knaw.dans.easy.domain.worker.WorkReporter;
import nl.knaw.dans.easy.servicelayer.services.DatasetService;
import nl.knaw.dans.easy.servicelayer.services.ItemService;
import nl.knaw.dans.easy.servicelayer.services.Services;
import nl.knaw.dans.easy.servicelayer.services.UserService;

import org.easymock.EasyMock;

public class MockUtil
{
    protected static final String     PASSWORD       = "secret";

    protected static final String     INVALID_USER_ID   = "nobody";
    protected static final String     VALID_USER_ID  = "somebody";
    protected static final String     ARCHIV_USER_ID = "archivist";

    private static final EasyUserImpl USER           = createSomeBody();
    private static final EasyUserImpl ARCHIVIST      = createArchivist();
    static {createMigrationUser();}

    private static int                countDatasets  = 0;

    public void mockAll() throws Exception {
        mockItemService();
        mockDatasetService();
        mockUser() ;
    }

    @SuppressWarnings("unchecked")
    public void mockItemService() throws Exception
    {
        final ItemService itemService = EasyMock.createMock(ItemService.class);
        new Services().setItemService(itemService);

        itemService.addDirectoryContents(//
                EasyMock.isA(EasyUserImpl.class), //
                EasyMock.isA(DatasetImpl.class), //
                EasyMock.isA(String.class), //
                EasyMock.isA(File.class), //
                EasyMock.isA(List.class), //
                EasyMock.isA(WorkReporter.class));
        EasyMock.expectLastCall().anyTimes();

        EasyMock.replay(itemService);
    }

    public void mockDatasetService() throws Exception
    {
        final Dataset dataset = new DatasetImpl("mock:" + (countDatasets++), MetadataFormat.SOCIOLOGY);
        final DatasetService datasetService = EasyMock.createMock(DatasetService.class);
        new Services().setDatasetService(datasetService);

        EasyMock.expect(datasetService.newDataset(MetadataFormat.SOCIOLOGY)).andReturn(dataset).anyTimes();

        datasetService.submitDataset(EasyMock.isA(DatasetSubmissionImpl.class), EasyMock.isA(WorkListener.class));
        EasyMock.expectLastCall().anyTimes();

        datasetService.submitDataset(EasyMock.isA(DatasetSubmissionImpl.class));
        EasyMock.expectLastCall().anyTimes();

        datasetService.publishDataset(//
                EasyMock.isA(EasyUser.class),//
                EasyMock.isA(DatasetImpl.class),//
                EasyMock.eq(false),//
                EasyMock.eq(true));
        EasyMock.expectLastCall().anyTimes();

        EasyMock.replay(datasetService);
    }

    public void mockUser() throws Exception
    {
        final EasyUserRepo userRepo = EasyMock.createMock(EasyUserRepo.class);
        final UserService userService = EasyMock.createMock(UserService.class);

        new Data().setUserRepo(userRepo);
        new Services().setUserService(userService);

        EasyMock.expect(userRepo.authenticate(VALID_USER_ID, PASSWORD)).andReturn(true).anyTimes();
        EasyMock.expect(userRepo.authenticate(INVALID_USER_ID, PASSWORD)).andReturn(false).anyTimes();
        EasyMock.expect(userRepo.authenticate(null, null)).andReturn(false).anyTimes();
        EasyMock.expect(userRepo.authenticate("", "")).andReturn(false).anyTimes();

        EasyMock.expect(userRepo.findById(VALID_USER_ID)).andReturn(USER).anyTimes();
        EasyMock.expect(userService.getUserById(null, VALID_USER_ID)).andReturn(USER).anyTimes();

        EasyMock.expect(userRepo.findById(ARCHIV_USER_ID)).andReturn(ARCHIVIST).anyTimes();
        EasyMock.expect(userService.getUserById(null, ARCHIV_USER_ID)).andReturn(ARCHIVIST).anyTimes();

        EasyMock.replay(userRepo, userService);
    }

    private static EasyUserImpl createSomeBody()
    {
        EasyUserImpl user = new EasyUserImpl();
        user.setId(VALID_USER_ID);
        user.setPassword(PASSWORD);
        user.setInitials("S.");
        user.setFirstname("Some");
        user.setSurname("Body");
        user.setEmail("some@body.com");
        user.setState(EasyUser.State.ACTIVE);
        return user;
    }

    private static EasyUserImpl createMigrationUser()
    {
        EasyUserImpl user = new EasyUserImpl();
        user.setId("migration");
        user.setPassword("migration");
        user.setInitials("M.");
        user.setFirstname("I.");
        user.setSurname("Gartion");
        user.setEmail("m.i.@gration.com");
        user.setState(EasyUser.State.ACTIVE);
        return user;
    }

    private static EasyUserImpl createArchivist()
    {
        Set<Role> roles = new HashSet<Role>();
        roles.add(Role.ARCHIVIST);
        EasyUserImpl archivist = new EasyUserImpl();
        archivist.setId(ARCHIV_USER_ID);
        archivist.setPassword(PASSWORD);
        archivist.setInitials("A.I.");
        archivist.setFirstname("Arch");
        archivist.setSurname("VIST");
        archivist.setEmail("arch.i.@vist.com");
        archivist.setState(EasyUser.State.ACTIVE);
        archivist.setRoles(roles);
        return archivist;
    }
}
