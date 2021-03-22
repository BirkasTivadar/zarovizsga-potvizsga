package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int result = 0;
        for (Cleanable cleanable : cleanables) {
            result += cleanable.clean();
        }
        cleanables.clear();
        return result;
    }

    public int cleanOnlyOffices() {
        List<Cleanable> offices = new ArrayList<>();
        int result = 0;
        for (Cleanable cleanable : cleanables) {
            if (cleanable instanceof Office) {
                result += cleanable.clean();
                offices.add(cleanable);
            }
        }
        cleanables.removeAll(offices);
        return result;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable.getAddress().contains(address)) {
                result.add(cleanable);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable cleanable : cleanables) {
            sb.append(cleanable.getAddress()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }


}
