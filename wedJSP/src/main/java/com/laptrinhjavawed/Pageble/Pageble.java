package com.laptrinhjavawed.Pageble;

import com.laptrinhjavawed.sort.Sorter;

public interface Pageble {
		Integer getPage();
		Integer getOffSet();
		Integer getLimit();
		Sorter getSorter();
}
