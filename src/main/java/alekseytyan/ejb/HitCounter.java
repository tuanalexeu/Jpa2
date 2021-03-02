package alekseytyan.ejb;

import javax.ejb.*;

@Singleton
// @ConcurrencyManagement(ConcurrencyManagementType.BEAN) - Optional, used when we want to keep concurrency under our control
public class HitCounter {

    private int count;

    @Lock(LockType.READ)
    public int getCount() {
        return count;
    }

    @Lock(LockType.WRITE)
    public void setCount(int count) {
        this.count = count;
    }

    @Lock(LockType.WRITE)
    public void increment() {
        count++;
    }

    @Lock(LockType.WRITE)
    public void decrement() {
        count--;
    }

    @Lock(LockType.WRITE)
    public void reset() {
        count = 0;
    }
}
