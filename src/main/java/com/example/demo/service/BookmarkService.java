package com.example.demo.service;

import com.example.demo.entity.Bookmark;
import com.example.demo.mapper.BookmarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    BookmarkMapper bookmarkMapper;

    public List<Bookmark> getAllBookmarks() {
        return bookmarkMapper.getAllBookmarks();
    }

    public void addBookmark(Bookmark bookmark) {
        bookmarkMapper.addBookmark(bookmark);
    }

    public Bookmark updateBookmark(Long id, String url, String title, String description) {
        Bookmark bookmark = bookmarkMapper.findById(id);
        if (bookmark == null) {
            return null;
        }
        bookmark.setUrl(url);
        bookmark.setTitle(title);
        bookmark.setDescription(description);
        bookmarkMapper.updateBookmark(bookmark);
        return bookmark;
    }

    public void deleteBookmark(Long id) {
        bookmarkMapper.deleteBookmark(id);
    }

    public List<Bookmark> searchBookmarks(String keyword) {
        return bookmarkMapper.searchBookmarks(keyword);
    }
}
