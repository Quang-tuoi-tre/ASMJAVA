package mu.ronaldo.lienquan.Asm.controller;

import mu.ronaldo.lienquan.Asm.Service.BookService;
import mu.ronaldo.lienquan.Asm.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /*@GetMapping(value = "/")
    public String Welcome() {
        return "Welcome back";
    }*/

    @GetMapping("/books")
    public List<Book> GetAll() {
        return bookService.getAll();
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id) {
        return bookService.get(id);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        bookService.add(book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id) {
        bookService.remove(id);
    }
    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book updatedBook) {
        bookService.update(id, updatedBook);
        return updatedBook;
    }

}
