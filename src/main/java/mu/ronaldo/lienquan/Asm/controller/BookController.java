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

    @GetMapping(value = "/")
    public String Welcome() {
        return "Welcome back";
    }

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
    @PostMapping("/Kiem-chuoi")
    public String CheckString(@RequestBody String str) {
        return isStringBalanced(str) ? "Ok" : "Not Ok";
    }

    private boolean isStringBalanced(String str) {
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('>', '<');

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (matchingBrackets.values().contains(ch)) {
                stack.push(ch);
            } else if (matchingBrackets.keySet().contains(ch)) {
                if (stack.isEmpty() || stack.pop() != matchingBrackets.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
