package libraryBookManager;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;



public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<IssueRecord> issueRecords;


    public Library(){

        books = new ArrayList<>();

        members = new ArrayList<>();

        issueRecords = new ArrayList<>();

        loadLibraryData();

        loadMemberData();
        loadIssueRecordData();

    }

    public void addIssueRecord(IssueRecord record){

        issueRecords.add(record);
        saveIssueRecordData();


    }
    public ArrayList<IssueRecord> viewAllIssueRecords(){

        return new ArrayList<>(issueRecords);

    }
    
    public void loadIssueRecordData(){


        try(BufferedReader reader =
                new BufferedReader(
                        new FileReader("issueRecords.txt")
                )){


            issueRecords.clear();


            String line;


            while((line = reader.readLine()) != null){


                if(line.trim().isEmpty()){

                    continue;

                }



                String data[] = line.split(",");



                if(data.length != 5){

                    continue;

                }



                String memberId = data[0];

                String isbn = data[1];

                String issueDate = data[2];

                boolean returned =
                        Boolean.parseBoolean(data[3]);
                String returnDate = data[4];


                IssueRecord record =
                        new IssueRecord(
                                memberId,
                                isbn,
                                issueDate
                        );


                record.setReturned(returned);
                if(returnDate.isEmpty()){

                    record.setReturnDate("");

                }
                else{

                    record.setReturnDate(returnDate);

                }
                issueRecords.add(record);
            }


        }
        catch(IOException e){


            System.out.println(
                    "No issue record data found."
            );


        }


    }
    public boolean addBook(Book book) {

    	if(book.getTitle().isEmpty()
    	        ||
    	   book.getAuthor().isEmpty()
    	        ||
    	   book.getISBN().isEmpty()
    	        ||
    	   book.getQuantity() < 0){

    	    return false;

    	}
        for (Book b : books) {


            if (b.getISBN().equals(book.getISBN())) {


                if(!b.getTitle().equalsIgnoreCase(book.getTitle())){


                    return false; // same ISBN but different title


                }


                b.setQuantity(
                        b.getQuantity() + book.getQuantity()
                );


                saveLibraryData();


                return true;


            }

        }



        books.add(book);

        saveLibraryData();


        return true;

    }



    public boolean removeBook(String isbn) {


        for(IssueRecord record : issueRecords){


            if(record.getISBN().equals(isbn)
                    &&
               !record.isReturned()){


                return false;

            }

        }



        for (int i = 0; i < books.size(); i++) {


            if (books.get(i).getISBN().equals(isbn)) {


                books.remove(i);

                saveLibraryData();


                return true;

            }

        }


        return false;

    }


    public boolean issueBook(String isbn, String memberId) {


        // Check member exists first

        Member member = searchMember(memberId);


        if(member == null){


            return false;


        }
        for(IssueRecord record : issueRecords){


            if(record.getMemberId().equals(memberId)
                    &&
               record.getISBN().equals(isbn)
                    &&
               !record.isReturned()){


                return false;


            }

        }



        for(Book book : books) {


            if(book.getISBN().equals(isbn)) {


                if(book.getQuantity() > 0) {


                    book.setQuantity(
                            book.getQuantity() - 1
                    );


                    IssueRecord record =
                            new IssueRecord(
                                    memberId,
                                    isbn,
                                    LocalDate.now().toString()
                            );


                    addIssueRecord(record);


                    saveLibraryData();



                    return true;


                }


                return false;


            }


        }


        return false;


    }




    public int returnBook(String isbn, String memberId) {


        for(IssueRecord record : issueRecords){


            if(record.getISBN().equals(isbn)
                    &&
               record.getMemberId().equals(memberId)
                    &&
               !record.isReturned()){


                int fine = calculateFine(record);



                record.setReturned(true);



                record.setReturnDate(
                        LocalDate.now().toString()
                );



                Book book = searchBookByISBN(isbn);



                if(book != null){


                    book.setQuantity(
                            book.getQuantity() + 1
                    );


                }



                saveLibraryData();

                saveIssueRecordData();



                return fine;


            }

        }


        return -1;

    }
    public Book searchBookByISBN(String isbn) {


        for (Book book : books) {


            if (book.getISBN().equals(isbn)) {


                return book;

            }

        }


        return null;

    }





    public ArrayList<Book> searchBookByTitle(String title) {


        ArrayList<Book> result = new ArrayList<>();


        for (Book book : books) {


            if(book.getTitle()
                    .toLowerCase()
                    .contains(title.toLowerCase())){


                result.add(book);

            }

        }


        return result;

    }




    public ArrayList<Book> viewAllBooks(){


        ArrayList<Book> sortedBooks =
                new ArrayList<>(books);



        for(int i = 0; i < sortedBooks.size() - 1; i++){


            for(int j = i + 1; j < sortedBooks.size(); j++){


                if(sortedBooks.get(i).getTitle()
                        .compareToIgnoreCase(
                                sortedBooks.get(j).getTitle()
                        ) > 0){


                    Book temp = sortedBooks.get(i);


                    sortedBooks.set(
                            i,
                            sortedBooks.get(j)
                    );


                    sortedBooks.set(
                            j,
                            temp
                    );


                }

            }

        }


        return sortedBooks;

    }







    public void saveLibraryData() {


        try (BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("books.txt")
                )) {



            for (Book book : books) {



            	writer.write(
            	        book.getTitle() + "," +
            	        book.getAuthor() + "," +
            	        book.getISBN() + "," +
            	        book.getQuantity() + "," +
            	        book.getCategory() + "," +
            	        book.getGenre()
            	);

                writer.newLine();


            }



        } catch (IOException e) {


            e.printStackTrace();


        }


    }

    public void loadMemberData(){


        try(BufferedReader reader =
                new BufferedReader(
                        new FileReader("members.txt")
                )){


            members.clear();


            String line;


            while((line = reader.readLine()) != null){


                if(line.trim().isEmpty()){

                    continue;

                }


                String data[] = line.split(",");



                if(data.length != 4){

                    continue;

                }



                String memberId = data[0];

                String name = data[1];

                String email = data[2];

                String phone = data[3];



                Member member = new Member(
                        memberId,
                        name,
                        email,
                        phone
                );


                members.add(member);


            }


        }
        catch(IOException e){


            System.out.println("No member data found.");

        }


    }

    // ================= DASHBOARD METHODS =================


    // Counts total book records

    public int getTotalBooks(){


        return books.size();


    }

    // Counts books that are currently available

    public int getAvailableBooks(){


        int count = 0;

        for(Book b : books){


            if(b.getQuantity() > 0){

               count++;

                      }



        }

        return count;

 }

            // Counts books that are currently unavailable

    public int getUnavailableBooks(){

        int count = 0;

        for(Book b : books){

       if(b.getQuantity() == 0){

          count++;
            
       }


        }

        return count;

    }

    public boolean addMember(Member member){
    	if(member.getMemberId().isEmpty()
    	        ||
    	   member.getName().isEmpty()){


    	    return false;

    	}

        for(Member m : members){


            if(m.getMemberId().equals(member.getMemberId())){


                return false;

            }

        }


        members.add(member);

        saveMemberData();
        return true;

    }
    public Member searchMember(String memberId){


        for(Member m : members){


            if(m.getMemberId().equals(memberId)){


                return m;

            }

        }


        return null;

    }
    public ArrayList<Member> viewAllMembers(){


        return new ArrayList<>(members);


    }
    public boolean removeMember(String memberId){


        // Check if member has unreturned books

        for(IssueRecord record : issueRecords){


            if(record.getMemberId().equals(memberId)
                    &&
               !record.isReturned()){


                return false;

            }

        }



        for(int i = 0; i < members.size(); i++){


            if(members.get(i).getMemberId()
                    .equals(memberId)){


                members.remove(i);


                saveMemberData();


                return true;

            }

        }


        return false;

    }



    public void loadLibraryData() {


        try (BufferedReader reader =
                new BufferedReader(
                        new FileReader("books.txt")
                )) {



            books.clear();



            String line;



            while ((line = reader.readLine()) != null) {



                if(line.trim().isEmpty()){


                    continue;


                }

                String data[] = line.split(",");



                if(data.length != 6){


                    continue;


                }

                String title = data[0];

                String author = data[1];

                String isbn = data[2];

                int quantity;

                try {

                    quantity = Integer.parseInt(data[3]);

                }
                catch(NumberFormatException e){

                    continue;

                }


                String category = data[4];

                String genre = data[5];




                Book book = new Book(
                        title,
                        author,
                        isbn,
                        quantity,
                        category,
                        genre
                );


                books.add(book);



            }



        } catch(IOException e) {

            System.out.println("No previous book data found.");

        }
        catch(NumberFormatException e){

            System.out.println("Invalid quantity data found.");

        }


    }
    public void saveMemberData(){


        try(BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("members.txt")
                )){


            for(Member member : members){


                writer.write(
                        member.getMemberId() + "," +
                        member.getName() + "," +
                        member.getEmail() + "," +
                        member.getPhone()
                );


                writer.newLine();

            }


        }
        catch(IOException e){


            e.printStackTrace();

        }


    }
    public void saveIssueRecordData(){


        try(BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("issueRecords.txt")
                )){


            for(IssueRecord record : issueRecords){


                writer.write(
                        record.getMemberId() + "," +
                        record.getISBN() + "," +
                        record.getIssueDate() + "," +
                        record.isReturned() + "," +
                        (record.getReturnDate() == null
                        ? ""
                        : record.getReturnDate())
                );


                writer.newLine();

            }


        }
        catch(IOException e){

            e.printStackTrace();

        }


    }
    public ArrayList<IssueRecord> getMemberIssueRecords(String memberId){

        ArrayList<IssueRecord> result = new ArrayList<>();


        for(IssueRecord record : issueRecords){

            if(record.getMemberId().equals(memberId)){

                result.add(record);

            }

        }


        return result;

    }
    public ArrayList<IssueRecord> getBookIssueRecords(String isbn){

        ArrayList<IssueRecord> result = new ArrayList<>();


        for(IssueRecord record : issueRecords){

            if(record.getISBN().equals(isbn)){

                result.add(record);

            }

        }


        return result;

    }
    public ArrayList<Book> searchBooksByCategory(String category){


        ArrayList<Book> result = new ArrayList<>();


        for(Book book : books){


            if(book.getCategory()
                    .equalsIgnoreCase(category)){


                result.add(book);

            }

        }


        return result;

    }
    public ArrayList<Book> searchBooksByGenre(String genre){


        ArrayList<Book> result = new ArrayList<>();


        for(Book book : books){


            if(book.getGenre()
                    .equalsIgnoreCase(genre)){


                result.add(book);

            }

        }


        return result;

    }
    public int calculateFine(IssueRecord record){


        LocalDate issueDate =
                LocalDate.parse(record.getIssueDate());



        LocalDate endDate;



        if(record.isReturned()
                &&
           record.getReturnDate() != null
                &&
           !record.getReturnDate().isEmpty()){


            endDate =
                    LocalDate.parse(
                            record.getReturnDate()
                    );


        }
        else{


            endDate =
                    LocalDate.now();


        }



        long borrowedDays =
                ChronoUnit.DAYS.between(
                        issueDate,
                        endDate
                );



        if(borrowedDays <= 14){


            return 0;


        }



        return (int)(borrowedDays - 14) * 100;


    }
    public boolean updateBook(String isbn, String title, String author,
            int quantity, String category, String genre){

    	if(title.isEmpty()
    	        ||
    	   author.isEmpty()
    	        ||
    	   quantity < 0){

    	    return false;

    	}
for(Book book : books){


if(book.getISBN().equals(isbn)){


book.setTitle(title);

book.setAuthor(author);

book.setQuantity(quantity);

book.setCategory(category);

book.setGenre(genre);



saveLibraryData();


return true;


}

}


return false;


}
    public boolean updateMember(String memberId, String name,
            String email, String phone){

    	if(name.isEmpty()
    	        ||
    	   email.isEmpty()){

    	    return false;

    	}
for(Member member : members){


if(member.getMemberId().equals(memberId)){


member.setName(name);

member.setEmail(email);

member.setPhone(phone);



saveMemberData();


return true;


}

}


return false;


}
   
}