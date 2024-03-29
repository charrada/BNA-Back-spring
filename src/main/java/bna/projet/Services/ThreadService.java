package bna.projet.Services;

import java.util.List;

public interface ThreadService {
    Thread addThread(Thread d);
    List<Thread> addThread (List<Thread> listThread);

    Thread updateThread (Thread d);
    List<Thread> updateThread (List<Thread> listThread);

    void deleteThread(Long id);
    void deleteThread(Thread d);

    List<Thread> findAllThread();
    Thread findThreadById (Long id);
}
