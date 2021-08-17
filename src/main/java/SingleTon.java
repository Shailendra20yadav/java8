public class SingleTon {
    private SingleTon() {
        if (instance!=null){
            throw new RuntimeException("Operation not supported");
        }
    }

    private static volatile SingleTon instance = null;

    public SingleTon getInstance() {

        if (instance == null) {

            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }

        return instance;

    }
}
