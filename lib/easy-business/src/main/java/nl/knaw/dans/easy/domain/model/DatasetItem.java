package nl.knaw.dans.easy.domain.model;

import nl.knaw.dans.common.lang.repo.DataModelObject;
import nl.knaw.dans.common.lang.repo.DmoStoreId;
import nl.knaw.dans.easy.domain.exceptions.DomainException;

public interface DatasetItem extends DataModelObject {
    DmoStoreId getDatasetId();

    DmoStoreId getParentId();

    void setDatasetId(DmoStoreId datasetId);

    void setParent(DatasetItemContainer parent) throws DomainException;

    boolean isDescendantOf(DmoStoreId dmoStoreId);

    boolean isDescendantOf(DataModelObject dmo);

    String getPath();

}