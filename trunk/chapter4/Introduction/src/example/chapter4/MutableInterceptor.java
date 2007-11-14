package example.chapter4;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class MutableInterceptor extends DelegatingIntroductionInterceptor
        implements Mutable {

    private boolean readonly = false;

    public boolean getReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        if(readonly && invocation.getMethod().getName().startsWith("set"))
//            throw new UnsupportedOperationException("Object is set to readonly!");
//        return super.invoke(invocation);
//    }

    @Override
    protected Object doProceed(MethodInvocation mi) throws Throwable {
        if(readonly && mi.getMethod().getName().startsWith("set"))
            throw new UnsupportedOperationException("Object is set to readonly!");
        return super.doProceed(mi);
    }

}
