package com.example.r4y.myapplication.Misc;

import java.util.List;

/**
 * Created by r4y on 2018/2/23.
 */
public class BlockInfo {

    /**
     * status : 1
     * message : OK
     * result : {"blockNumber":"2165403","timeStamp":"1472533979","blockMiner":"0x13a06d3dfe21e0db5c016c03ea7d2509f7f8d1e3","blockReward":"5314181600000000000","uncles":[{"miner":"0xbcdfc35b86bedf72f0cda046a3c16829a2ef41d1","unclePosition":"0","blockreward":"3750000000000000000"},{"miner":"0x0d0c9855c722ff0c78f21e43aa275a5b8ea60dce","unclePosition":"1","blockreward":"3750000000000000000"}],"uncleInclusionReward":"312500000000000000"}
     */

    private String status;

    private String message;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * blockNumber : 2165403
         * timeStamp : 1472533979
         * blockMiner : 0x13a06d3dfe21e0db5c016c03ea7d2509f7f8d1e3
         * blockReward : 5314181600000000000
         * uncles : [{"miner":"0xbcdfc35b86bedf72f0cda046a3c16829a2ef41d1","unclePosition":"0","blockreward":"3750000000000000000"},{"miner":"0x0d0c9855c722ff0c78f21e43aa275a5b8ea60dce","unclePosition":"1","blockreward":"3750000000000000000"}]
         * uncleInclusionReward : 312500000000000000
         */

        private String blockNumber;
        private String timeStamp;
        private String blockMiner;
        private String blockReward;
        private String uncleInclusionReward;
        private List<UnclesBean> uncles;

        public String getBlockNumber() {
            return blockNumber;
        }

        public void setBlockNumber(String blockNumber) {
            this.blockNumber = blockNumber;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getBlockMiner() {
            return blockMiner;
        }

        public void setBlockMiner(String blockMiner) {
            this.blockMiner = blockMiner;
        }

        public String getBlockReward() {
            return blockReward;
        }

        public void setBlockReward(String blockReward) {
            this.blockReward = blockReward;
        }

        public String getUncleInclusionReward() {
            return uncleInclusionReward;
        }

        public void setUncleInclusionReward(String uncleInclusionReward) {
            this.uncleInclusionReward = uncleInclusionReward;
        }

        public List<UnclesBean> getUncles() {
            return uncles;
        }

        public void setUncles(List<UnclesBean> uncles) {
            this.uncles = uncles;
        }

        public static class UnclesBean {
            /**
             * miner : 0xbcdfc35b86bedf72f0cda046a3c16829a2ef41d1
             * unclePosition : 0
             * blockreward : 3750000000000000000
             */

            private String miner;
            private String unclePosition;
            private String blockreward;

            public String getMiner() {
                return miner;
            }

            public void setMiner(String miner) {
                this.miner = miner;
            }

            public String getUnclePosition() {
                return unclePosition;
            }

            public void setUnclePosition(String unclePosition) {
                this.unclePosition = unclePosition;
            }

            public String getBlockreward() {
                return blockreward;
            }

            public void setBlockreward(String blockreward) {
                this.blockreward = blockreward;
            }
        }
    }
}

