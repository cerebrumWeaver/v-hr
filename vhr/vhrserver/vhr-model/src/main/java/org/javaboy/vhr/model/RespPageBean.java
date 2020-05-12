package org.javaboy.vhr.model;

import java.io.Serializable;
import java.util.List;


public class RespPageBean implements Serializable {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RespPageBean{");
        sb.append("total=").append(total);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
