package nl.dans.knaw.easy.mock;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;
import nl.knaw.dans.common.lang.repo.DmoStoreId;
import nl.knaw.dans.easy.data.Data;
import nl.knaw.dans.easy.domain.migration.IdMap;
import nl.knaw.dans.easy.domain.model.Dataset;
import nl.knaw.dans.easy.domain.model.FileItem;
import nl.knaw.dans.easy.mock.BusinessMocker;
import nl.knaw.dans.easy.mock.FileHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class BusinessMockerTest
{
    private BusinessMocker mock;

    @Before
    public void setUp() throws Exception
    {
        mock = new BusinessMocker();
    }

    @After
    public void verifyAll()
    {
        mock.verifyAll();
    }

    @Test
    public void easyStoreRetrieve() throws Exception
    {
        final String storeId = "easy-dataset:1";
        final Dataset mockedDataset = mock.dataset(storeId).getDataset();

        mock.replayAll();

        final Dataset retrievedDataset = (Dataset) Data.getEasyStore().retrieve(new DmoStoreId(storeId));
        assertThat(retrievedDataset, sameInstance(mockedDataset));
    }

    @Test
    public void getMigrationAipId() throws Exception
    {
        final String storeId = "easy-dataset:1";
        final String aipId = "twips-1";
        mock.dataset(storeId).withAipId(aipId);

        mock.replayAll();

        final IdMap idMap = Data.getMigrationRepo().findById(storeId);
        assertThat(idMap.getAipId(), equalTo(aipId));
    }

    @Test
    public void noPurge() throws Exception
    {
        final String path = "tif/2.tif";
        final FileHelper helper = mock.file(path);

        mock.replayAll();

        final FileItem fi = (FileItem) Data.getEasyStore().retrieve(new DmoStoreId(helper.getStoreId()));
        assertThat(fi, equalTo(helper.getFileItem()));
        assertThat(fi.getPath(), equalTo(path));
    }
}
