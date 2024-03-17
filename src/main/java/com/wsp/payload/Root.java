package com.wsp.payload;

import java.util.ArrayList;
import java.util.List;

public class Root {

        private String journeyType;
        private String cabinClass;
        private Boolean isOriginMetro;
        private Boolean isDestMetro;
        private List<SearchCriterium> searchCriteria = new ArrayList<SearchCriterium>();
        private PaxInfo paxInfo;
        public String getJourneyType() {
            return journeyType;
        }
        public void setJourneyType(String journeyType) {
            this.journeyType = journeyType;
        }
        public String getCabinClass() {
            return cabinClass;
        }
        public void setCabinClass(String cabinClass) {
            this.cabinClass = cabinClass;

        }
        public Boolean getIsOriginMetro() {
            return isOriginMetro;
        }
        public void setIsOriginMetro(Boolean isOriginMetro) {
            this.isOriginMetro = isOriginMetro;
        }
        public Boolean getIsDestMetro() {
            return isDestMetro;
        }
        public void setIsDestMetro(Boolean isDestMetro) {
            this.isDestMetro = isDestMetro;
        }
        public List<SearchCriterium> getSearchCriteria() {
            return searchCriteria;
        }
        public void setSearchCriteria(List<SearchCriterium> searchCriteria) {
            this.searchCriteria = searchCriteria;
        }
        public PaxInfo getPaxInfo() {
            return paxInfo;
        }
        public void setPaxInfo(PaxInfo paxInfo) {
            this.paxInfo = paxInfo;
        }

}
