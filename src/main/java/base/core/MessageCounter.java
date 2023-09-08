package base.core;

import javax.inject.Inject;


//public class MessageCounter {
//    private final String message;
//    private final int count;
//
//    @Inject
//    MessageCounter(@Message String msg, @Count int count) {
//        this.message = msg;
//        this.count = count;
//    }
//
//    public void printer() {
//        for (int i = 0; i < this.count; i++) {
//            System.out.println(this.message);
//        }
//    }
//
//}

interface TestInterface {
    String getString();

    int getCount();
}

public class MessageCounter {
    private final String message;
    private final int count;

    @Inject
    MessageCounter(TestInterface impl) {
        this.message = impl.getString();
        this.count = impl.getCount();
    }

    public void printer() {
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.message);
        }
    }

}
