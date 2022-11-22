package com.lbms.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lbms.LBMS;
import javafx.scene.control.Alert.AlertType;

public class DatabaseService {

	public static Member login(int card_id, String name) {
		Member member = null;
		
		try (var con = MyConnection.createConnection()) {

			var sql = "SELECT * FROM members WHERE card_id = ? AND name = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setInt(1, card_id);
			pstm.setString(2, name);

			var rs = pstm.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setCard_id(rs.getInt("card_id"));
				member.setName(rs.getString("name"));
				member.setRoll_no(rs.getInt("roll_no"));
				member.setYear(rs.getString("year"));
				member.setAcademic_year(rs.getString("academic_year"));
				member.setCreated_date(LocalDate.parse(rs.getString("created_date")));
				member.setExpired_date(LocalDate.parse(rs.getString("expired_date")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public static void registerMember(Member member) throws Exception {
		try (var con = MyConnection.createConnection()) {
			var sql = "INSERT INTO members(name, roll_no, year, academic_year, created_date, expired_date)VALUES(?, ?, ?, ?, ?, ?)";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, member.getName());
			pstm.setInt(2, member.getRoll_no());
			pstm.setString(3, member.getYear());
			pstm.setString(4, member.getAcademic_year());
			pstm.setDate(5, Date.valueOf(LocalDate.now()));
			pstm.setDate(6, Date.valueOf(LocalDate.now().plusYears(1)));

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<Member> findAllMembers() {
		List<Member> list = new ArrayList<>();

		try (var con = MyConnection.createConnection()) {

			var sql = "SELECT * FROM members ORDER BY created_date";
			var pstm = con.prepareStatement(sql);

			var rs = pstm.executeQuery();
			while (rs.next()) {

				var member = new Member();
				member.setCard_id(rs.getInt("card_id"));
				member.setName(rs.getString("name"));
				member.setRoll_no(rs.getInt("roll_no"));
				member.setYear(rs.getString("year"));
				member.setAcademic_year(rs.getString("academic_year"));
				member.setCreated_date(LocalDate.parse(rs.getString("created_date")));
				member.setExpired_date(LocalDate.parse(rs.getString("expired_date")));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Member> searchMemberList(String card_id, String name) {
		List<Member> list = new ArrayList<>();

		try (var con = MyConnection.createConnection()) {

			var sql = "SELECT * FROM members ";

			List<Object> params = new ArrayList<>();

			if (!card_id.equals("") && !name.equals("")) {
				sql += "WHERE card_id LIKE ? AND name LIKE ?";
				params.add("%" + card_id + "%" + "%" + name + "%");
			} else if (!card_id.equals("")) {
				sql += "WHERE card_id LIKE ?";
				params.add("%" + card_id + "%");
			} else if (!name.equals("")) {
				sql += "WHERE name LIKE ?";
				params.add("%" + name + "%");
			} else {
				LBMS.showAlert(AlertType.ERROR, "Please Enter Something");
			}

			var pstm = con.prepareStatement(sql);
			for (var i = 0; i < params.size(); i++) {
				pstm.setObject(i + 1, params.get(i));
			}

			var rs = pstm.executeQuery();
			while (rs.next()) {
				var member = new Member();
				member.setCard_id(rs.getInt("card_id"));
				member.setName(rs.getString("name"));
				member.setRoll_no(rs.getInt("roll_no"));
				member.setYear(rs.getString("year"));
				member.setAcademic_year(rs.getString("academic_year"));
				member.setCreated_date(LocalDate.parse(rs.getString("created_date")));
				member.setExpired_date(LocalDate.parse(rs.getString("expired_date")));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public static Member searchMember(String card_id, String name) {
		var member = new Member();
		try (var con = MyConnection.createConnection()) {

			var sql = "SELECT * FROM members ";

			List<Object> params = new ArrayList<>();

			if (!card_id.equals("") && !name.equals("")) {
				sql += "WHERE card_id LIKE ? AND name LIKE ?";
				params.add("%" + card_id + "%" + "%" + name + "%");
			} else if (!card_id.equals("")) {
				sql += "WHERE card_id LIKE ?";
				params.add("%" + card_id + "%");
			} else if (!name.equals("")) {
				sql += "WHERE name LIKE ?";
				params.add("%" + name + "%");
			} else {
				LBMS.showAlert(AlertType.ERROR, "Please Enter Something");
			}
			sql += " LIMIT 1";

			var pstm = con.prepareStatement(sql);
			for (var i = 0; i < params.size(); i++) {
				pstm.setObject(i + 1, params.get(i));
			}

			var rs = pstm.executeQuery();
			while (rs.next()) {
				member.setCard_id(rs.getInt("card_id"));
				member.setName(rs.getString("name"));
				member.setRoll_no(rs.getInt("roll_no"));
				member.setYear(rs.getString("year"));
				member.setAcademic_year(rs.getString("academic_year"));
				member.setCreated_date(LocalDate.parse(rs.getString("created_date")));
				member.setExpired_date(LocalDate.parse(rs.getString("expired_date")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public static void deleteMember(int card_id) throws Exception {

		try (var con = MyConnection.createConnection()) {
			var sql = "DELETE FROM members WHERE card_id = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setInt(1, card_id);
			pstm.executeUpdate();

		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void updateMember(Member member) throws Exception {
		try(var con = MyConnection.createConnection()) {
			var sql = "UPDATE members SET name = ?, roll_no = ?, year = ?, academic_year = ? WHERE card_id = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, member.getName());
			pstm.setDouble(2, member.getRoll_no());
			pstm.setString(3, member.getYear());
			pstm.setString(4, member.getAcademic_year());
			pstm.setInt(5, member.getCard_id());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void deleteExpiredMember() throws Exception {
		
		try(var con = MyConnection.createConnection()) {
			var sql = "DELETE FROM members WHERE expired_date = ?";
			var pstm = con.prepareStatement(sql);
			
			pstm.setDate(1, Date.valueOf(LocalDate.now()));
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static List<Category> findAllCategories() throws Exception {
		List<Category> list = new ArrayList<>();
		
		try(var con = MyConnection.createConnection()) {
			var sql = "SELECT * FROM categories";
			
			var pstm = con.prepareStatement(sql);
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				var category = new Category();
				
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				
				list.add(category);
			}
		}
		catch (Exception e) {
			throw e;
		}
		
		return list;
	}
	
	public static void addCategory(String name) throws Exception {
		
		try(var con = MyConnection.createConnection()) {
			var sql = "INSERT INTO categories(name)VALUES(?)";
			
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			
			pstm.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}
	}

	public static List<Author> findAllAuthors() throws Exception {
		List<Author> list = new ArrayList<>();
		
		try(var con = MyConnection.createConnection()) {
			var sql = "SELECT * FROM authors ORDER BY id";
			
			var pstm = con.prepareStatement(sql);
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				var author = new Author();
				
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				
				list.add(author);
			}
		}
		catch (Exception e) {

		}
		return list;
	}

	public static void addAuthor(Author author) throws Exception {
		try (var con = MyConnection.createConnection()) {
			var sql = "INSERT INTO authors(name, city, birthday)VALUES(?, ?, ?)";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCity());
			pstm.setDate(3, Date.valueOf(author.getBirthday()));

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteAuthor(Author author) throws Exception {
		
		try(var con = MyConnection.createConnection()) {
			var sql = "DELETE FROM authors WHERE name = ? AND city = ? AND birthday = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCity());
			pstm.setDate(3, Date.valueOf(author.getBirthday()));
			pstm.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}
	}

	public static void updateAuthor(Author author) throws Exception {
		
		try(var con = MyConnection.createConnection()) {
			var sql = "UPDATE authors SET name = ?, city = ?, birthday = ? WHERE name = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCity());
			pstm.setDate(3, Date.valueOf(author.getBirthday()));
			pstm.setString(4, author.getName());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	public static Author searchAuthor(String name) throws Exception {
		Author author = null;
		
		try(var con = MyConnection.createConnection()) {
			var sql = "SELECT * FROM authors WHERE name LIKE ? LIMIT 1";
			var pstm = con.prepareStatement(sql);
			
			pstm.setString(1, "%" + name + "%");
			
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				author = new Author();
				author.setId(rs.getInt("id"));
				author.setCity(rs.getString("city"));
				author.setName(rs.getString("name"));
				author.setBirthday(LocalDate.parse(rs.getString("birthday")));
			}
		} catch (Exception e) {
			throw e;
		}
		return author;
	}

	public static void addLibrarian(Librarian librarian) throws Exception {
		try (var con = MyConnection.createConnection()) {
			var sql = "INSERT INTO librarians(name, email, password, nrcno, phone)VALUES(?, ?, ?, ?, ?)";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, librarian.getName());
			pstm.setString(2, librarian.getEmail());
			pstm.setString(3, librarian.getPassword());
			pstm.setString(4, librarian.getNrcno());
			pstm.setString(5, librarian.getPhone());

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	public static Librarian LoginLibrarian(String email, String password) {
		Librarian librarian = null;

		try (var con = MyConnection.createConnection()) {

			var sql = "SELECT * FROM librarians WHERE email = ? AND password = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, password);

			var rs = pstm.executeQuery();
			if (rs.next()) {
				librarian = new Librarian();
				librarian.setId(rs.getInt("id"));
				librarian.setName(rs.getString("name"));
				librarian.setEmail(rs.getString("email"));
				librarian.setPassword(rs.getString("password"));
				librarian.setNrcno(rs.getString("nrcno"));
				librarian.setPhone(rs.getString("phone"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return librarian;
	}

	public static Book searchBook(String title) {
		Book book = null;
		try(var con = MyConnection.createConnection()) {
			var sql = """
					SELECT b.author_id, b.category_id, b.created_by, b.code, b.title, b.publish_date, b.available, a.name 'author', c.name 'category', l.id, l.email
					FROM books b, authors a, categories c, librarians l
					WHERE b.author_id = a.id AND 
					b.category_id = c.id AND 
					b.created_by = l.id AND b.title LIKE ?
					""";
			var pstm = con.prepareStatement(sql);
			
			pstm.setString(1, "%" + title + "%");
			
			var rs = pstm.executeQuery();
			
			if (rs.next()) {
				book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				
				var author = new Author();
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("author"));
				book.setAuthor(author);
				
				var category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category"));
				book.setCategory(category);

				book.setAvailable(rs.getString("available"));
				
				var librarian = new Librarian();
				librarian.setId(rs.getInt("created_by"));
				librarian.setEmail(rs.getString("email"));
				book.setCreated_by(librarian);
			}
		} catch (Exception e) {
			
		}
		
		return book;
	}
	public static void addBook(Book book) throws Exception {
		try (var con = MyConnection.createConnection()) {
			var sql = "INSERT INTO books(title, publish_date, author_id, category_id, available, created_by)VALUES(?, ?, ?, ?, ?, ?)";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, book.getTitle());
			pstm.setDate(2, Date.valueOf(book.getPublish_date()));
			pstm.setInt(3, book.getAuthor().getId());
			pstm.setInt(4, book.getCategory().getId());
			pstm.setString(5, "Y");
			pstm.setInt(6, LBMS.LoginLibrarian.getId());

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void deleteBook(String title) {
		try (var con = MyConnection.createConnection()) {
			var sql = "DELETE FROM books WHERE title = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, title);
			pstm.executeUpdate();

		} catch (Exception e) {

		}
	}
	
	public static void updateBook(Book book, String title) {
		try(var con = MyConnection.createConnection()) {
			var sql = "UPDATE books SET title = ?, publish_date = ?, author_id = ?, category_id = ? WHERE title = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, book.getTitle());
			pstm.setDate(2, Date.valueOf(book.getPublish_date()));
			pstm.setInt(3, book.getAuthor().getId());
			pstm.setInt(4, book.getCategory().getId());
			pstm.setString(5, title);
			
			pstm.executeUpdate();
		} catch (Exception e) {

		}
	}

	public static List<Book> findAllBooks() {
		List<Book> list = new ArrayList<>();
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = """
					SELECT b.code, b.title, b.publish_date, b.available, c.name 'category', a.name 'author', l.name 'librarian'
					FROM books b, authors a, categories c, librarians l 
					WHERE b.author_id = a.id AND
						b.created_by = l.id AND
						b.category_id = c.id
					""";
			var pstm = con.prepareStatement(sql);
			
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				var book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.getAuthor().setName(rs.getString("author"));
				book.getCategory().setName(rs.getString("category"));
				book.getCreated_by().setName(rs.getString("librarian"));
				book.setAvailable(rs.getString("available"));;
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));

				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static List<Book> searchBook(String author, String category, String title) {
		List<Book> list = new ArrayList<>();
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = """
					SELECT b.code, b.title, b.publish_date, b.available, c.name 'category', a.name 'author', l.name 'librarian'
					FROM books b, authors a, categories c, librarians l 
					WHERE b.author_id = a.id AND
						b.created_by = l.id AND
						b.category_id = c.id
					""";
//			dynamic query
			List<Object> params = new ArrayList<>();
			if(!author.equals("")) {
				sql += " AND a.name LIKE ?";
				params.add("%" + author + "%");
			}
			
			if(!category.equals("")) {
				sql += " AND c.name LIKE ?";
				params.add("%" + category + "%");
			}
			
			if(!title.equals("")) {
				sql += " AND b.title LIKE ?";
				params.add("%" + title + "%");
			}
			var pstm = con.prepareStatement(sql);

			for(var i = 0; i < params.size(); i++) {
				pstm.setObject(i + 1, params.get(i));
			}
			var rs = pstm.executeQuery();
			while(rs.next()) {

				var book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.getAuthor().setName(rs.getString("author"));
				book.getCategory().setName(rs.getString("category"));
				book.getCreated_by().setName(rs.getString("librarian"));
				book.setAvailable(rs.getString("available"));;
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));

				list.add(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void borrowBook(Book book) {
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = "UPDATE books SET available = ?, borrowed_by = ?, borrowed_date = ?, due_date = ? WHERE code = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, "N");
			pstm.setInt(2, LBMS.LoginMember.getCard_id());
			pstm.setDate(3, Date.valueOf(LocalDate.now()));
			pstm.setDate(4, Date.valueOf(LocalDate.now().plusWeeks(1)));
			pstm.setInt(5, book.getCode());
			pstm.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void borrowedBooks() {
		Book book = null;
		try (var con = MyConnection.createConnection()) {
			var sql = """
					SELECT b.code, b.title, b.publish_date, c.name 'category', a.name 'author', l.name 'librarian'
					FROM books b, authors a, categories c, librarians l, members m 
					WHERE b.author_id = a.id AND
						b.created_by = l.id AND
						b.category_id = c.id AND 
						m.card_id = b.borrowed_by AND
						m.card_id = ?
					""";
			var pstm = con.prepareStatement(sql);
			pstm.setInt(1, LBMS.LoginMember.getCard_id());
			var rs = pstm.executeQuery();

			if (rs.next()) {
				book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.getAuthor().setName(rs.getString("author"));
				book.getCategory().setName(rs.getString("category"));
				book.getCreated_by().setName(rs.getString("librarian"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
				LBMS.LoginMember.setBorrowedBook(book);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static List<Book> findAllBorrowedBooks() {
		List<Book> list = new ArrayList<>();
		
		try(var con = MyConnection.createConnection()) {
			
			var sql = """
					SELECT b.code, b.title, b.publish_date, c.name 'category', a.name 'author', l.name 'librarian'
					FROM books b, authors a, categories c, librarians l 
					WHERE b.author_id = a.id AND
						b.created_by = l.id AND
						b.category_id = c.id AND
						b.borrowed_by = ?
					""";
			var pstm = con.prepareStatement(sql);
			pstm.setInt(1, LBMS.LoginMember.getCard_id());
			
			var rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				var book = new Book();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.getAuthor().setName(rs.getString("author"));
				book.getCategory().setName(rs.getString("category"));
				book.getCreated_by().setName(rs.getString("librarian"));
				book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));

				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static void returnBook(Book book) {
		try(var con = MyConnection.createConnection()) {
			
			var sql = "UPDATE books SET available = ?, borrowed_by = ?, borrowed_date = ?, due_date = ? WHERE code = ?";
			var pstm = con.prepareStatement(sql);
			pstm.setString(1, "Y");
			pstm.setInt(2, 0);
			pstm.setDate(3, null);
			pstm.setDate(4, null);
			pstm.setInt(5, book.getCode());

			pstm.executeUpdate();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fineMember(Book book, Integer fees) throws Exception {
		
		try (var con = MyConnection.createConnection()) {
			var sql = "INSERT INTO transactions(card_id, book_id, borrow_date, due_date, fees, lib_id)VALUES(?, ?, ?, ?, ?, ?)";
			var pstm = con.prepareStatement(sql);
			pstm.setInt(1, LBMS.LoginMember.getCard_id());
			pstm.setInt(2, book.getCode());
			pstm.setDate(3, Date.valueOf(book.getBorrowed_date()));
			pstm.setDate(4, Date.valueOf(book.getDue_date()));
			pstm.setInt(5, fees);
			pstm.setInt(6, book.getCreated_by().getId());

			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}
}
