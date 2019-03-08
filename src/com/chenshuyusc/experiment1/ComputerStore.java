package com.chenshuyusc.experiment1;

import java.util.ArrayList;
import java.util.List;

public class ComputerStore {
    private List<Computer> computers = new ArrayList<>();

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void addComputers(ArrayList<Computer> computers) {
        this.computers.addAll(computers);
    }

    public void clear() {
        computers.clear();
    }

    public void remove(int i) {
        computers.remove(i);
    }

    public void remove(Computer computer) {
        computers.remove(computer);
    }

    public List<Computer> getComputers() {
        return computers;
    }
}
