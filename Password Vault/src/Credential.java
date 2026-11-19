import java.util.Objects;



    public class Credential{
        private  final String site;
        private  final String username;
        private final  String password;


        private static String requireText(String value , String fieldName){
            if (value == null || value.isBlank()){
                throw new IllegalArgumentException(fieldName + " cannot be empty");
            }
            return value;
        }




        public String getSite() {return site;}
        public String getUsername() {return username;}
        public String getPassword() {return password;}

        @Override
        public String toString() {//return method
            return site + " ("  + username + ") ****";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Credential that = (Credential) o;
            return site.equals(that.site) && username.equals(that.username) ;

        }

        @Override
        public int hashCode() {
            return Objects.hash(site, username);

        }


        public Credential(String site, String username, String password){
            this.site = requireText(site , "Site");
            this.username = requireText(username , "Username");
            this.password = requireText(password , "Password");

        }

    }// MAIN


