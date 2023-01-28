package sample.Models;



import java.util.ArrayList;

public class Document  {

        private int idDocuments;
        private String DocName;
        private String DocPath;
        private String DocDesc;



//methodes
    //Constructor
        public Document( String docName, String docPath, String docDesc) {

            DocName = docName;
            DocPath = docPath;
            DocDesc = docDesc;
        }

            //attributes


            public Document() {
                super();
            }

        //getters
        public String getDocDesc() {
            return DocDesc;
        }
        public String getDocPath() {
            return DocPath;
        }
        public String getDocName() {
            return DocName;
        }
        public int getIdDocuments() {
            return idDocuments;
        }



    //setters
        public void setIdDocuments(int idDocuments) {
            this.idDocuments = idDocuments;
        }
        public void setDocDesc(String docDesc) {
            DocDesc = docDesc;
        }
        public void setDocPath(String docPath) {
        DocPath = docPath;
        }
        public void setDocName(String docName) {
            DocName = docName;
        }
}
