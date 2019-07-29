package behavioral;


public interface Iterator {
    public boolean hasNext();

    public Object next();
}

interface Container {
    Iterator getIterator();
}

//数组迭代
class NameRepository implements Container {

    private String[] repository = new String[]{"Robert", "John", "Julie", "Lora"};

    private NameIterator nameIterator;

    public NameRepository() {
        this.nameIterator = new NameIterator();
    }

    @Override
    public Iterator getIterator() {
        return nameIterator;
    }

    private class NameIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < repository.length;
        }

        @Override
        public Object next() {
            return repository[index++];
        }
    }
}

class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();
        Iterator iter = namesRepository.getIterator();
        while (iter.hasNext()) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
