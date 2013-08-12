package com.cnblsp2.studyt.aidlservice;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Person居然还要跟IPerson.aidl，Person.aidl 在一个目录下，真心不好用~
 * @author cpic
 *
 */
public class Person implements Parcelable {

	private Integer id;
	private String name;
	private String pass;

	public Person() {
	}

	public Person(Integer id, String name, String pass) {
		super();
		setId(id);
		setName(name);
		setPass(pass);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}

		Person other = (Person) o;
		if (name == null) {
			if (other != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}

		if (pass == null) {
			if (other.pass != null) {
				return false;
			}
		} else if (!pass.equals(other.pass)) {
			return false;
		}
		return true;

	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeString(pass);
	}

	/**
	 * 
	 */
	public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {

		@Override
		public Person createFromParcel(Parcel source) {
			return new Person(source.readInt(), source.readString(), source.readString());
		}

		@Override
		public Person[] newArray(int size) {
			return new Person[size];
		}
	};

}
