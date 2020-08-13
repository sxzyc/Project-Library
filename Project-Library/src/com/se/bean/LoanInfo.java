package com.se.bean;

public class LoanInfo {
    /*���ı��*/
    private int loadId;
    
    
    public LoanInfo() {
		super();
	}

	public LoanInfo(int loadId, String name, String book, String status, String reader, String borrowDate,
			String returnDate) {
		super();
		this.loadId = loadId;
		this.name = name;
		this.book = book;
		this.status = status;
		this.reader = reader;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}



	public int getLoadId() {
        return loadId;
    }
    public void setLoadId(int loadId) {
        this.loadId = loadId;
    }
    
    private String name;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*ͼ�����*/
    private String book;
    

    public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
	
	private String status;
	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	/*���߶���*/
    private String reader;
   

    public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	/*����ʱ��*/
    private String borrowDate;
    public String getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    /*�黹ʱ��*/
    private String returnDate;
    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

}