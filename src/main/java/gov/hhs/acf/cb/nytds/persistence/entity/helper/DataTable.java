/**
 * Filename: DataTable.java
 * 
 * Copyright 2009, ICF International Created: Aug 20, 2009 Author: 18816
 * 
 * COPYRIGHT STATUS: This work, authored by ICF International employees, was
 * funded in whole or in part under U.S. Government contract, and is, therefore,
 * subject to the following license: The Government is granted for itself and
 * others acting on its behalf a paid-up, nonexclusive, irrevocable worldwide
 * license in this work to reproduce, prepare derivative works, distribute
 * copies to the public, and perform publicly and display publicly, by or on
 * behalf of the Government. All other rights are reserved by the copyright
 * owner.
 */
package gov.hhs.acf.cb.nytds.persistence.entity.helper;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Representation of data ready to be exported.
 * 
 * The DataTable can be thought of as having rows and columns, where
 * the rows represent individual records in the database and the columns
 * represent the fields/elements of the record.
 * 
 * Note that the DataTable is not a list of lists, but implements a single list
 * of data (TableDatumBean). The second list, the list of fields (TableFieldBean),
 * can be accessed via the getFields() method.
 * 
 * This class was designed with both the pmStation SPSS Writer and
 * JasperReports cross-tabulations in mind.
 * 
 * In order to use the object:
 * (1) initialize it (obviously),
 * (2) populate the fields with addField(),
 * (3) populate the data via add() or addAll().
 * (4) access the data via the various get*() methods.
 * 
 * @author Adam Russell (18816)
 */
public class DataTable implements List<TableDatumBean>, Serializable
{

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<TableDatumBean> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(TableDatumBean tableDatumBean) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends TableDatumBean> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends TableDatumBean> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public TableDatumBean get(int index) {
		return null;
	}

	@Override
	public TableDatumBean set(int index, TableDatumBean element) {
		return null;
	}

	@Override
	public void add(int index, TableDatumBean element) {

	}

	@Override
	public TableDatumBean remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<TableDatumBean> listIterator() {
		return null;
	}

	@Override
	public ListIterator<TableDatumBean> listIterator(int index) {
		return null;
	}

	@Override
	public List<TableDatumBean> subList(int fromIndex, int toIndex) {
		return null;
	}
}
