package me.personal.progress.factorymethod.factory;

import me.personal.progress.factorymethod.entity.IReader;
import me.personal.progress.factorymethod.entity.JpgReader;

/**
 * Created by zhongyi on 2018/8/21.
 */
public class JpgReaderFactory implements IReaderFactory {
    @Override
    public IReader getIReader() {
        return new JpgReader();
    }
}