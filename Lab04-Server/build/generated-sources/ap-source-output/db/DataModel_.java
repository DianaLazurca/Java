package db;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-09T22:53:47")
@StaticMetamodel(DataModel.class)
public class DataModel_ { 

    public static volatile SingularAttribute<DataModel, String> machineID;
    public static volatile SingularAttribute<DataModel, Integer> quantity;
    public static volatile SingularAttribute<DataModel, String> productID;
    public static volatile SingularAttribute<DataModel, Float> price;
    public static volatile SingularAttribute<DataModel, Integer> id;
    public static volatile SingularAttribute<DataModel, Date> timestamp;

}