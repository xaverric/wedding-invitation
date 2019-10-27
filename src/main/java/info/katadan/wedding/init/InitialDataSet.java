package info.katadan.wedding.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitialDataSet {

    private final List<DataSet> datasets;

    @Autowired
    public InitialDataSet(List<DataSet> datasets) {
        this.datasets = datasets;
    }

    public InitializingBean load() {
        datasets.forEach(t -> t.load());

        return null;
    }

}