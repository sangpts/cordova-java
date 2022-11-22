package vn.edu.greenwich.cw_1_sample.models;

import java.io.Serializable;

public class Resident implements Serializable {
    protected long _id;
    protected String _name;
    protected String _startDate;
    protected int _owner;
    protected String _destination;
    protected String _description;
    protected String _vehicle;
    protected String _hotel;
    protected String _place;

    public Resident() {
        _id = -1;
        _name = null;
        _startDate = null;
        _owner = -1;
        _destination = null;
        _description = null;
        _vehicle = null;
        _hotel = null;
        _place = null;
    }

    public Resident(long id, String name,String destination, String description, String vehicle, String hotel, String place, String startDate, int owner) {
        _id = id;
        _name = name;
        _startDate = startDate;
        _owner = owner;
        _description = description;
        _destination = destination;
        _vehicle = vehicle;
        _hotel = hotel;
        _place = place;
    }

    public long getId() { return _id; }
    public void setId(long id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }

    public String getStartDate() {
        return _startDate;
    }
    public void setStartDate(String startDate) {
        _startDate = startDate;
    }

    public int getOwner() {
        return _owner;
    }
    public void setOwner(int owner) {
        _owner = owner;
    }

    public String getDestination() {
        return _destination;
    }
    public void setDestination(String destination) {
        _destination = destination;
    }

    public String getDescription() {
        return _description;
    }
    public void setDescrtiption(String description) {
        _description = description;
    }

    public String getVehicle() {
        return _vehicle;
    }
    public void setVehicle(String vehicle) {
        _vehicle = vehicle;
    }

    public String getHotel() {
        return _hotel;
    }
    public void setHotel(String hotel) {
        _hotel = hotel;
    }

    public String getPlace() {
        return _place;
    }
    public void setPlace(String place) {
        _place = place;
    }

    public boolean isEmpty() {
        if (-1 == _id && null == _name && null == _startDate && -1 == _owner && null == _description && null == _destination && null == _vehicle && null == _hotel&& null == _place)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "[" + _startDate + "] " + _name;
    }
}