package com.zhuhao.design_mode.adapter.a;

import com.zhuhao.design_mode.adapter.a.immutable.Filter;
import com.zhuhao.design_mode.adapter.a.immutable.Waveform;

/**
 * 适配器
 *
 * @Author halk
 * @Date 2020/11/11 14:44
 */
public class FilterAdapter implements Processor {

    private Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
