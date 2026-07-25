package libraryBookManager;

public class IssueRecord {


    private String memberId;
    private String isbn;
    private String issueDate;
    private boolean returned;
    private String returnDate;



    public IssueRecord(String memberId, String isbn, String issueDate){

        this.memberId = memberId;
        this.isbn = isbn;
        this.issueDate = issueDate;
        this.returned = false;
        this.returnDate = "";

    }



    public String getMemberId(){

        return memberId;

    }



    public String getISBN(){

        return isbn;

    }



    public String getIssueDate(){

        return issueDate;

    }



    public boolean isReturned(){

        return returned;

    }



    public void setReturned(boolean returned){

        this.returned = returned;

    }
    public String getReturnDate(){

        return returnDate;

    }
    public void setReturnDate(String returnDate){

        this.returnDate = returnDate;

    }


}