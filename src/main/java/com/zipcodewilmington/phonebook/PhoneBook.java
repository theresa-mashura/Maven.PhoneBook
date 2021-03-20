package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<String, List<String>>(map);
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        this.phonebook.put(name, new ArrayList<String>(Arrays.asList(phoneNumber)));
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        if (this.phonebook.get(name).contains(phoneNumber)) {
            return true;
        } return false;
    }

    public Boolean hasEntry(String name) {
        if (this.phonebook.containsKey(name)) {
            return true;
        } return false;
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> al = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: this.phonebook.entrySet()) {
            al.add(entry.getKey());
        }
        return al;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
