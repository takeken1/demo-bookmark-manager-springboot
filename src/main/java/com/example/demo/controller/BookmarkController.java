package com.example.demo.controller;

import com.example.demo.entity.Bookmark;
import com.example.demo.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @GetMapping("")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public ResponseEntity<List<Bookmark>> getAllBookmarks() {
        List<Bookmark> bookmarks = bookmarkService.getAllBookmarks();
        return new ResponseEntity<>(bookmarks, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBookmark(@RequestBody Bookmark bookmark) {
        bookmarkService.addBookmark(bookmark);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bookmark> updateBookmark(@PathVariable Long id, @RequestBody Bookmark newBookmark) {
        Bookmark updatedBookmark = bookmarkService.updateBookmark(id, newBookmark.getUrl(), newBookmark.getTitle(), newBookmark.getDescription());
        if (updatedBookmark == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBookmark);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable("id") Long id) {
        bookmarkService.deleteBookmark(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Bookmark>> searchBookmarks(@RequestParam(value = "keyword") String keyword) {
        List<Bookmark> bookmarks = bookmarkService.searchBookmarks(keyword);
        return new ResponseEntity<>(bookmarks, HttpStatus.OK);
    }
}
