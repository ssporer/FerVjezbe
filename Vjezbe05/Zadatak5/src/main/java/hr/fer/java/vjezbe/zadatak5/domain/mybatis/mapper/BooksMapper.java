package hr.fer.java.vjezbe.zadatak5.domain.mybatis.mapper;

import hr.fer.java.vjezbe.zadatak5.model.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper public interface BooksMapper {

    static final String SELECT_BOOK_BY_TITLE =
            "SELECT"
                    + " a.FIRST_NAME as authorFirstName,"
                    + " a.LAST_NAME as authorLastName,"
                    + " b.TITLE"
                    + " FROM LIBRARY.BOOK b"
                    + " LEFT OUTER JOIN LIBRARY.AUTHOR a"
                    + " ON (b.AUTHOR_ID = a.ID)"
                    + " WHERE upper(TITLE) = upper(#{title})";

    @Select(SELECT_BOOK_BY_TITLE) public BookDto getBookByTitle(String title);

}
