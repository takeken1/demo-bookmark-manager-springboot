package com.example.demo.mapper;

import com.example.demo.entity.Bookmark;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookmarkMapper {

    @Select("SELECT * FROM bookmarks")
    List<Bookmark> getAllBookmarks();

    @Select("SELECT * FROM bookmarks WHERE id=#{id}")
    Bookmark findById(Long id);

    @Insert("INSERT INTO bookmarks (url, title, description) VALUES (#{url}, #{title}, #{description})")
    void addBookmark(Bookmark bookmark);

    @Update("UPDATE bookmarks SET url=#{url}, title=#{title}, description=#{description} WHERE id=#{id}")
    void updateBookmark(Bookmark bookmark);

    @Delete("DELETE FROM bookmarks WHERE id=#{id}")
    void deleteBookmark(Long id);

    @Select("SELECT * FROM bookmarks WHERE title LIKE CONCAT('%', #{keyword}, '%') OR description LIKE CONCAT('%', #{keyword}, '%')")
    List<Bookmark> searchBookmarks(String keyword);
}
