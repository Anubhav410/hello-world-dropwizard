package base.core;

import com.google.inject.AbstractModule;

import javax.inject.Qualifier;

@Qualifier
@interface Message {
}

@Qualifier
@interface Count {
}

class MyImpl implements TestInterface {
    @Override
    public String getString() {
        return "awesome man!";
    }

    @Override
    public int getCount() {
        return 10;
    }

//    @Override
//    public Class<? extends Annotation> annotationType() {
//        return null;
//    }
}

public class MyModule extends AbstractModule {

//    @Provides
//    @Count
//    static Integer provideCount() {
//        return 7;
//    }
//
//    @Provides
//    @Message
//    static String provideMessage() {
//        return "hi bro!";
//    }

    @Override
    protected void configure() {
        bind(TestInterface.class).to(MyImpl.class);
    }
}
