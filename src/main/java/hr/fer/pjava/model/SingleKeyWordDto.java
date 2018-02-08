package hr.fer.pjava.model;

import java.io.Serializable;

/**
 * Created by Igor Farszky on 8.2.2018..
 */
public class SingleKeyWordDto implements Serializable {

    public String keyword;

    public SingleKeyWordDto() {
    }

    public SingleKeyWordDto(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
