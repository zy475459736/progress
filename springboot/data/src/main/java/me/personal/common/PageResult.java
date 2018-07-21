package me.personal.common;

/**
 * Created by zhongyi on 2018/7/21.
 */
public class PageResult<T> extends Result{

    private Page page = new Page(0,0,0);

    public static class Page{
        private long total;
        private int current;
        private int pageSize;

        public Page(long total,int current,int pageSize){
            this.total = total;
            this.current = current;
            this.pageSize = pageSize;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}