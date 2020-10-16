package com.oldlie.common.utils.accountcreator;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OLDLIE
 * @date 2020/10/16
 */
public class NameListener extends AnalysisEventListener<Name> {

    private Name name;
    private List<String> nameList;
    public List<String> getNameList () {
        return this.nameList;
    }

    public NameListener() {
        this.name = new Name();
        this.nameList = new ArrayList<>();
    }

    @Override
    public void invoke(Name name, AnalysisContext analysisContext) {
        this.nameList.add(name.getName());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
