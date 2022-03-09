package delivery;

public enum Workload {
    VERY_HIGH(){
        @Override
        public double getRatio(){
            return 1.6;
        }
    }
    , HIGH(){
        @Override
        public double getRatio(){
            return 1.4;
        }
    }
    , INCREASED(){
        @Override
        public double getRatio(){
            return 1.2;
        }
    }
    , NORMAL(){
        @Override
        public double getRatio(){
            return 1;
        }
    };
    public abstract double getRatio();
}