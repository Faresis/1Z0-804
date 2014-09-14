package ua.dp.mign.nested.local;

class Outer {
    Outer getLocal() {
        class Local extends Outer {
            public String toString() {
                return "Local";
            }
        }
        return new Local();
    }

    static Outer wrap(Outer o) {
        class Wrapper extends Outer {
            private Outer entity;
            Wrapper(Outer o) {
                this.entity = o;
            }
            public String toString() {
                return "Wrapped statically ( " + entity + " )";
            }
        }
        return new Wrapper(o);
    }
    
    Outer getWrapper() {
        class Wrapper extends Outer {
            public String toString() {
                return "Wrapped locally ( " + Outer.this + " )";
            }
        }
        return new Wrapper();
    }

    Outer processEntities(final Outer... entities) {
        class Processor extends Outer {
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("All of them: ");
                for(Outer entity : entities) {
                    sb.append(" ");
                    sb.append(entity);
                    sb.append(" ");
                }
                return sb.toString();
            }
        }
        return new Processor();
    }

    public String toString() {
        return "Outer";
    }
}

class InClass {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer l = o.getLocal();
        Outer wos = Outer.wrap(o);
        Outer wls = Outer.wrap(l);
        Outer wol = o.getWrapper();
        Outer wll = l.getWrapper();
        Outer p = o.processEntities(o,l,wos,wls,wol,wll);
        System.out.println(o);
        System.out.println(l);
        System.out.println(wos);
        System.out.println(wls);
        System.out.println(wol);
        System.out.println(wll);
        System.out.println(p);
    }
}
