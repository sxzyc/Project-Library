package com.se.bean;

public class Book {
    /*ͼ��������*/
    private String barcode;
    private int id;
    
    public Book() {
		super();
	}

	public Book(String barcode, int id, String bookName, int bookTypeid, float price, int count, String publishDate,
			String publish, String introduction, String bookPhoto) {
		super();
		this.barcode = barcode;
		this.id = id;
		this.bookName = bookName;
		this.bookTypeid = bookTypeid;
		this.price = price;
		this.count = count;
		this.publishDate = publishDate;
		this.publish = publish;
		this.introduction = introduction;
		this.bookPhoto = bookPhoto;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /*ͼ������*/
    private String bookName;
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /*ͼ���������*/
    private int bookTypeid;

	public int getBookTypeid() {
		return bookTypeid;
	}

	public void setBookTypeid(int bookTypeid) {
		this.bookTypeid = bookTypeid;
	}

	/*ͼ��۸�*/
    private float price;
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    /*���*/
    private int count;
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    /*��������*/
    private String publishDate;
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    /*������*/
    private String publish;
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }

    /*ͼ����*/
    private String introduction;
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /*ͼ��ͼƬ*/
    private String bookPhoto;
    public String getBookPhoto() {
        return bookPhoto;
    }
    public void setBookPhoto(String bookPhoto) {
        this.bookPhoto = bookPhoto;
    }

}