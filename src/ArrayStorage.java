import java.util.Arrays;
import java.util.Objects;
import java.util.Collections;
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
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == r.uuid) {
                System.out.println(" uuid " + r.uuid + " already exists");
                return;
            }
        }
        if (size < storageSize) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Storage Is Full");
        }
    }



    Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < size; i++) {
            Resume resume = storage[i];
            if (resume != null && uuid.equals(resume.uuid)) {
                return resume;
            } else {
                System.out.println("TAKOGO UUID NET");
                break;
            }
        }
        return null;
    }

  /*  int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {

                return i+1;
            }
        }
        return -1;
    }
*/
    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;

            }
        }
        System.out.println("Resume not exist");
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