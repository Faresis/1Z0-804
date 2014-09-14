package ua.dp.mign.nested.anonymous;

class BaseClass {
    private int width;
    private int height;

    BaseClass(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public String toString() {
        return "width: " + width + " height: " + height;
    }

    public BaseClass getWrapper() {
        return new BaseClass(0,0) {
            public String toString() {
                return "OUTER THIS: " + BaseClass.this.toString();
            }
        };
    }
}

class InClass {
    public static void main(String[] args) {
       final BaseClass bc = new BaseClass(3,4);
       System.out.println(bc); 
       System.out.println(bc.getWrapper()); 

       BaseClass bce = new BaseClass(4,5) {
           public String toString() {
               return "EXTENDED: " + super.toString();
           }
       };
       System.out.println(bce); 

       BaseClass bcw = new BaseClass(0,0) {
           public String toString() {
               return "WRAPPED: "+ bc.toString();
           }
       };
       System.out.println(bcw); 
    }
}
