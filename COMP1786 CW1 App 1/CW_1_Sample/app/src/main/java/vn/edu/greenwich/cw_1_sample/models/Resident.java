package vn.edu.greenwich.cw_1_sample.models;

import android.util.Log;

import java.io.Serializable;

public class Resident implements Serializable {
    protected long _id;
    protected String _name;
    protected String _startDate;
    protected int _owner;

    public Resident() {
        _id = -1;
        _name = null;
        _startDate = null;
        _owner = -1;
    }

    public Resident(long id, String name, String startDate, int owner) {
        _id = id;
        _name = name;
        _startDate = startDate;
        _owner = owner;
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

    public boolean isEmpty() {
        if (-1 == _id && null == _name && null == _startDate && -1 == _owner)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "[" + _startDate + "] " + _name;
    }
}