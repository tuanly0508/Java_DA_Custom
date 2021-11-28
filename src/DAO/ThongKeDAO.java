package DAO;

import java.util.List;

public class ThongKeDAO extends AbsDAO{
    
    public List<Object[]> tableDefaul() {
        return getRawValues("");
    }
}
