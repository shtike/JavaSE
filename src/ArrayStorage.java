import com.sun.glass.ui.Size;
import com.sun.security.auth.SolarisNumericUserPrincipal;

import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[100000];
    int size=0 ;

    String uuid;

   

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage = null;
        }
    }

    void save(Resume r) {
for (int i =0; i<storage.length; i++){

    if(storage [i]==null){
        storage[i]=r;
        size++;
        return;

    }
}




    Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < storage.length; i++) {
            Resume resume = storage[i];
            if (resume != null && uuid.equals(resume.uuid)) {
                return r;
            }
        }
        return resume;
    }

    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {

        }
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid == uuid) {
                storage[i] = storage[size];

                size--;

            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll(){

        for (int i = 0; i < size; i++) {


            }

        return storage;
    }

    public int size(){

        return 0;
    }


}


