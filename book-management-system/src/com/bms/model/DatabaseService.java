package com.bms.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bms.BMS;

public class DatabaseService {

	public static User login(String email, String pass) {
		User user = null;
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = "SELECT * FROM users WHERE email = ? AND password = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, pass);
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static void saveCategory(String name) throws Exception {
		try(var con = MyConnection.createConnection()){
			
			var sql = "INSERT INTO categories(name, created_at, updated_at, created_by)VALUES(?, ?, ?, ?)";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setDate(2, Date.valueOf(LocalDate.now()));
			pstm.setDate(3, Date.valueOf(LocalDate.now()));
			pstm.setInt(4, BMS.loginUser.getId());
			
			pstm.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		}
		
	}

	public static List<Category> findAllCategories() {
		List<Category> list = new ArrayList<>();
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = "SELECT * FROM categories ORDER BY created_at";
			var pstm = con.prepareStatement(sql);
			
			var rs = pstm.executeQuery();
			while(rs.next()) {
				// create new category object
				var cat = new Category();
				
				// convert row to object(col value -> obj's field)
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				cat.setUpdated_at(LocalDate.parse(rs.getString("updated_at"))); // string = 2022-10-4 (rs.getstring())
				cat.setCreated_at(LocalDate.parse(rs.getString("created_at")));
				
				// add to list
				list.add(cat);
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	public static void updateCategory(Category category) throws Exception {
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = "UPDATE categories SET name = ?, updated_at = ? WHERE id = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, category.getName());
			pstm.setInt(3, category.getId());
			pstm.setDate(2, Date.valueOf(LocalDate.now()));
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	public static List<Book> findAllBook() {
		List<Book> list = new ArrayList<>();
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = """
					SELECT b.code, b.title, b.price, c.name 'category', a.name 'author', u.email
					FROM books b, authors a, categories c, users u
					WHERE b.author_id = a.id AND
						b.created_by = u.id AND
						b.category_id = c.id
					""";
			var pstm = con.prepareStatement(sql);
			
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				// create obj
				var book = new Book();
				// bind table's row to java obj
				book.setId(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getDouble("price"));
				book.getAuthor().setName(rs.getString("author"));
				book.getCategory().setName(rs.getString("category"));
				book.getCreated_by().setEmail(rs.getString("email"));
				// add to list
				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static List<Author> findAllAuthors() {
		List<Author> list = new ArrayList<>();
		try(var con = MyConnection.createConnection()) {
			var sql = "SELECT a.*, u.email FROM authors a, users u WHERE a.created_by = u.id";
			var pstm = con.prepareStatement(sql);
			var rs = pstm.executeQuery();
			while(rs.next()) {
//				create object
				var author = new Author();
				
//				convert row's column to obj's field
				author.setBirthday(LocalDate.parse(rs.getString("birthday")));
				author.setCity(rs.getString("city"));
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				
				var created_by = new User();
				created_by.setEmail(rs.getString("email"));
				created_by.setId(rs.getInt("created_by"));
				
				author.setUser(created_by);
				
//				add to list
				list.add(author);
			}
		} catch (Exception e) {
			
		}
		
		return list;
	}

	public static void saveBook(Book book) throws Exception {
		
	try(var con = MyConnection.createConnection()) {
		var sql = "INSERT INTO books(code, price, title, author_id, category_id, created_by)VALUES(?, ?, ?, ?, ?, ?)";
		var pstm = con.prepareStatement(sql);
		pstm.setInt(1, book.getId());
		pstm.setDouble(2, book.getPrice());
		pstm.setString(3, book.getTitle());
		pstm.setInt(4, book.getAuthor().getId());
		pstm.setInt(5, book.getCategory().getId());
		pstm.setInt(6, BMS.loginUser.getId());
		
		pstm.executeUpdate();
	} catch (Exception e) {
		throw e;
	}
	}

	public static Book findById(int id) {
		Book book = null;
		try(var con = MyConnection.createConnection()) {
			var sql = """
					SELECT b.author_id, b.category_id, b.code, b.title, b.price, c.name 'category', a.name 'author', u.email
					FROM books b, authors a, categories c, users u
					WHERE b.author_id = a.id AND
						b.created_by = u.id AND
						b.category_id = c.id AND b.code = ?
					""";
			var pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			
			var rs = pstm.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setId(rs.getInt("code"));
				book.setPrice(rs.getDouble("price"));
				book.setTitle(rs.getString("title"));
				
				var author = new Author();
				author.setName(rs.getString("author"));
				author.setId(rs.getInt("author_id"));
				book.setAuthor(author);
				
				var category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category"));
				book.setCategory(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return book;
	}

	public static void updateBook(Book book) throws Exception {
		try(var con = MyConnection.createConnection()) {
			var sql = "UPDATE books SET title = ?, price = ?, category_id = ?, author_id = ? WHERE code = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, book.getTitle());
			pstm.setDouble(2, book.getPrice());
			pstm.setInt(3, book.getCategory().getId());
			pstm.setInt(4, book.getAuthor().getId());
			pstm.setInt(5, book.getId());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteById(int id) throws Exception {
		
		try(var con = MyConnection.createConnection()) {
			var sql = "DELETE FROM books WHERE code = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<Book> searchBook(String authorName, String categoryName, String title) {
		List<Book> list = new ArrayList<>();
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = """
					SELECT b.code, b.title, b.price, c.name 'category', a.name 'author', u.email
					FROM books b, authors a, categories c, users u
					WHERE b.author_id = a.id AND
						b.created_by = u.id AND
						b.category_id = c.id
					""";
//			dynamic query
			List<Object> params = new ArrayList<>();
			if(!authorName.equals("")) {
				sql += " AND a.name LIKE ?";
				params.add("%" + authorName + "%");
			}
			
			if(!categoryName.equals("")) {
				sql += " AND c.name LIKE ?";
				params.add("%" + categoryName + "%");
			}
			
			if(!title.equals("")) {
				sql += " AND b.title LIKE ?";
				params.add("%" + title + "%");
			}
			var pstm = con.prepareStatement(sql);

//			bind params
			for(var i = 0; i < params.size(); i++) {
				pstm.setObject(i + 1, params.get(i));
			}
			var rs = pstm.executeQuery();
			while(rs.next()) {
				// create obj
				var book = new Book();
				// bind table's row to java obj
				book.setId(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getDouble("price"));
				book.getAuthor().setName(rs.getString("author"));
				book.getCategory().setName(rs.getString("category"));
				book.getCreated_by().setEmail(rs.getString("email"));
				// add to list
				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
