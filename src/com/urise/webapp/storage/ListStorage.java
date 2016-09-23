package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by Admin on 30.08.16.
 */
public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer  searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume r, Integer  searchKey) {
        list.set( searchKey, r);
    }


    @Override
    protected void doSave(Resume r, Integer  searchKey) {
        list.add( r);
    }

    @Override
    protected Resume doGet(Integer  searchKey) {
        return list.get( searchKey);
    }

    @Override
    protected void doDelete(Integer  searchKey) {
        list.remove(( searchKey).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isResumeExist(Resume resume) {
        return false;
    }

//    List<Resume> resumeList = new ArrayList<>();
//    ArrayList al2 = new ArrayList();
//    ArrayList al = (ArrayList) resumeList;
//    Iterator<Resume> iterator = resumeList.iterator();
//    Resume resume = new Resume();
//
//
//
//    public void clear() {
//
//        resumeList.clear();
//    }
//
//    public void save(Resume r) {
//
//        resumeList.add(r);
//    }
//
//    public void update(Resume r) {
//        int index = getSearchKey(r.getUuid());
//        if (resumeList.contains(r) == true)
//            al.add(index);
//        else throw new NotExistStorageException(r.getUuid());
//
//    }
//
//    public void getAll1() {
//        for (Resume r : resumeList) {
//            System.out.println(r);
//        }
//    }
//
//    public Resume get(String uuid) {
//
//        for (Resume r : resumeList) {
//            r.getUuid().equals(uuid);
//            if (r.getUuid() == uuid) {
//                return r;
//            } else throw new NotExistStorageException(r.getUuid());
//        }
//        return  null;
//    }
//
//
//    public void delete(String uuid) {
//        resumeList.remove(uuid);
//    }
//
//
//    @Override
//    protected Integer getSearchKey(String uuid) {
//        for (int i = 0; i < size; i++) {
//            if (storage[i].getUuid().equals(uuid)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//
//    @Override
//    protected void fillDeletedElement(int index) {
//
//    }
//
//    @Override
//    protected void insertElement(Resume r, int index) {

//}


}
