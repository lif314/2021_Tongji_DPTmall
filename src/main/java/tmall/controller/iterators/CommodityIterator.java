package tmall.controller.iterators;

import tmall.model.entity.Commodity;

import java.util.Iterator;
import java.util.List;

public class CommodityIterator implements Iterator<Commodity>{
    /**
     * @description: 迭代器模式
     * 商品迭代器
     */
        private final List<Commodity> allCmdties;
        private int index = 0;
        public CommodityIterator(List<Commodity> cmties){
            this.allCmdties = cmties;
        }
        @Override
        public boolean hasNext(){
            return this.index < this.allCmdties.size();
        }

        @Override
        public Commodity next() {
            if (this.hasNext())
                return this.allCmdties.get(index++);
            return null;
        }
}
