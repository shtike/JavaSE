import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int storageSize = 10000;
    Resume[] storage = new Resume[storageSize];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {

        if (getIndex(r.uuid) != -1)
            System.out.println("Resume allready exist");
        else{
        if (size<storageSize)
            storage[size]=r;
            size++;
    }
    }


    Resume get(String uuid) {

        if (getIndex(uuid) == -1) {
            System.out.println("Resume not exist");

            return null;
        } else

            return storage[getIndex(uuid)];


    }


    int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    void delete(String uuid) {
        if (getIndex(uuid) == -1)
            System.out.println("Resume not exist");
        else {
            storage[getIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);

//        Resume[] nepustoy = new Resume[size];
//        for (int i = 0; i < size; i++) {
//            nepustoy[i] = storage[i];
//        }
//        return nepustoy;
    }
/**
 * @return array, contains only Resumes in storage (without null)*/

}