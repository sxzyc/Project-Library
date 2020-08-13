package com.se.bean;

public class Reader {
	private int id;
	
    /*���߱��*/
    private String readerNo;
    
    
    public Reader() {
		super();
	}

    
	public Reader(int id, String readerNo, int readerType, String readerName, String sex, String telephone,
			String email, String qq, String address, String photo, String readerPaw) {
		super();
		this.id = id;
		this.readerNo = readerNo;
		this.readerType = readerType;
		this.readerName = readerName;
		this.sex = sex;
		this.telephone = telephone;
		this.email = email;
		this.qq = qq;
		this.address = address;
		this.photo = photo;
		this.readerPaw = readerPaw;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReaderNo() {
        return readerNo;
    }
    public void setReaderNo(String readerNo) {
        this.readerNo = readerNo;
    }

    /*��������*/
    private int readerType;

    public int getReaderType() {
		return readerType;
	}

	public void setReaderType(int readerType) {
		this.readerType = readerType;
	}

	/*����*/
    private String readerName;
    public String getReaderName() {
        return readerName;
    }
    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    /*�Ա�*/
    private String sex;
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    /*��ϵ�绰*/
    private String telephone;
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /*��ϵEmail*/
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    /*��ϵqq*/
    private String qq;
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }

    /*���ߵ�ַ*/
    private String address;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    /*����ͷ��*/
    private String photo;
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    private String readerPaw;

	public String getReaderPaw() {
		return readerPaw;
	}


	public void setReaderPaw(String readerPaw) {
		this.readerPaw = readerPaw;
	}
    
    
}