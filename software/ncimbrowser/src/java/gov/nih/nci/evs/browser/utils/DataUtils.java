package gov.nih.nci.evs.browser.utils;

import java.io.*;
import java.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.HashSet;
import java.util.Arrays;

import javax.faces.model.SelectItem;

import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.SortOptionList;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeSummary;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.Impl.LexBIGServiceImpl;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption;
import org.LexGrid.LexBIG.Utility.Constructors;
import org.LexGrid.LexBIG.Utility.LBConstants.MatchAlgorithms;
import org.LexGrid.concepts.Concept;

import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.CodingSchemeRendering;

import org.LexGrid.LexBIG.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.DataModel.Collections.ModuleDescriptionList;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.ModuleDescription;


import org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator;
import org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList;

import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;

import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;

import org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList;
import org.LexGrid.LexBIG.DataModel.Core.NameAndValue;

import org.LexGrid.LexBIG.DataModel.Collections.AssociationList;
import org.LexGrid.LexBIG.DataModel.Core.AssociatedConcept;
import org.LexGrid.LexBIG.DataModel.Core.Association;
import org.LexGrid.LexBIG.DataModel.Collections.AssociatedConceptList;

import org.LexGrid.codingSchemes.CodingScheme;
import org.LexGrid.concepts.Definition;
import org.LexGrid.concepts.Comment;
import org.LexGrid.concepts.Presentation;

import org.apache.log4j.Logger;

import org.LexGrid.LexBIG.Exceptions.LBResourceUnavailableException;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;

import org.LexGrid.LexBIG.Utility.ConvenienceMethods;
import org.LexGrid.commonTypes.EntityDescription;

import org.LexGrid.commonTypes.Property;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;

import org.LexGrid.LexBIG.DataModel.Collections.AssociationList;
import org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.AssociatedConcept;
import org.LexGrid.LexBIG.DataModel.Core.Association;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeSummary;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.Impl.LexBIGServiceImpl;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.ActiveOption;
import org.LexGrid.LexBIG.Utility.ConvenienceMethods;
import org.LexGrid.commonTypes.EntityDescription;
import org.LexGrid.commonTypes.Property;
import org.LexGrid.concepts.Concept;

import org.LexGrid.relations.Relations;

import org.LexGrid.commonTypes.PropertyQualifier;

import org.LexGrid.commonTypes.Source;
import org.LexGrid.naming.SupportedSource;

import org.LexGrid.naming.SupportedPropertyQualifier;
import org.LexGrid.LexBIG.DataModel.Core.types.CodingSchemeVersionStatus;

import org.LexGrid.naming.SupportedAssociation;
import org.LexGrid.naming.SupportedAssociationQualifier;

import org.LexGrid.naming.SupportedProperty;
import org.LexGrid.naming.SupportedPropertyQualifier;
import org.LexGrid.naming.SupportedRepresentationalForm;
import org.LexGrid.naming.SupportedSource;

import org.LexGrid.LexBIG.DataModel.Collections.AssociatedConceptList;
import org.LexGrid.LexBIG.DataModel.Collections.AssociationList;
import org.LexGrid.LexBIG.DataModel.Core.AssociatedConcept;
import org.LexGrid.LexBIG.DataModel.Core.Association;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeSummary;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods;
import org.LexGrid.LexBIG.Impl.LexBIGServiceImpl;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.naming.Mappings;
import org.LexGrid.naming.SupportedHierarchy;

import org.LexGrid.LexBIG.DataModel.InterfaceElements.RenderingDetail;
import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeTagList;

import gov.nih.nci.evs.browser.properties.NCImBrowserProperties;
import gov.nih.nci.evs.browser.utils.test.DBG;

import org.LexGrid.LexBIG.Exceptions.LBParameterException;


import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.SortOptionList;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeSummary;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.Impl.LexBIGServiceImpl;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption;
import org.LexGrid.LexBIG.Utility.Constructors;
import org.LexGrid.LexBIG.Utility.LBConstants.MatchAlgorithms;
import org.LexGrid.concepts.Entity;


/**
  * <!-- LICENSE_TEXT_START -->
* Copyright 2008,2009 NGIT. This software was developed in conjunction with the National Cancer Institute,
* and so to the extent government employees are co-authors, any rights in such works shall be subject to Title 17 of the United States Code, section 105.
* Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
* 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the disclaimer of Article 3, below. Redistributions
* in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other
* materials provided with the distribution.
* 2. The end-user documentation included with the redistribution, if any, must include the following acknowledgment:
* "This product includes software developed by NGIT and the National Cancer Institute."
* If no such end-user documentation is to be included, this acknowledgment shall appear in the software itself,
* wherever such third-party acknowledgments normally appear.
* 3. The names "The National Cancer Institute", "NCI" and "NGIT" must not be used to endorse or promote products derived from this software.
* 4. This license does not authorize the incorporation of this software into any third party proprietary programs. This license does not authorize
* the recipient to use any trademarks owned by either NCI or NGIT
* 5. THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
* MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO EVENT SHALL THE NATIONAL CANCER INSTITUTE,
* NGIT, OR THEIR AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
* PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
* WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
  * <!-- LICENSE_TEXT_END -->
  */

/**
  * @author EVS Team
  * @version 1.0
  *
  * Modification history
  *     Initial implementation kim.ong@ngc.com
  *
 */

public class DataUtils {
    private static Vector<String> sourceListData = null;
    LocalNameList noopList_ = Constructors.createLocalNameList("_noop_");
    static SortOptionList sortByCode_ = Constructors.createSortOptionList(new String[] {"code"});

    //int maxReturn = 5000;
    Connection con;
    Statement stmt;
    ResultSet rs;

    private List supportedStandardReportList = new ArrayList();

    private static List standardReportTemplateList = null;
    private static List adminTaskList = null;
    private static List userTaskList = null;

    private static List propertyTypeList = null;

    private static List _ontologies = null;

    private static org.LexGrid.LexBIG.LexBIGService.LexBIGService lbSvc = null;
    public org.LexGrid.LexBIG.Utility.ConvenienceMethods lbConvMethods = null;
    public CodingSchemeRenderingList csrl = null;
    private Vector supportedCodingSchemes = null;
    private static HashMap codingSchemeMap = null;
    private Vector codingSchemes = null;

    private static HashMap csnv2codingSchemeNameMap = null;
    private static HashMap csnv2VersionMap = null;

    private static List directionList = null;


    //==================================================================================
    // For customized query use

    public static int ALL = 0;
    public static int PREFERRED_ONLY = 1;
    public static int NON_PREFERRED_ONLY = 2;

    static int RESOLVE_SOURCE = 1;
    static int RESOLVE_TARGET = -1;
    static int RESTRICT_SOURCE = -1;
    static int RESTRICT_TARGET = 1;

    public static final int SEARCH_NAME_CODE = 1;
    public static final int SEARCH_DEFINITION = 2;

    public static final int SEARCH_PROPERTY_VALUE = 3;
    public static final int SEARCH_ROLE_VALUE = 6;
    public static final int SEARCH_ASSOCIATION_VALUE = 7;

    static final List<String> STOP_WORDS = Arrays.asList(new String[] {
        "a", "an", "and", "by", "for", "of", "on", "in", "nos", "the", "to", "with"});

    public static String TYPE_ROLE = "type_role";
    public static String TYPE_ASSOCIATION = "type_association";
    public static String TYPE_SUPERCONCEPT = "type_superconcept";
    public static String TYPE_SUBCONCEPT = "type_subconcept";
    public static String TYPE_SIBLINGCONCEPT = "type_siblingconcept";
    public static String TYPE_BROADERCONCEPT = "type_broaderconcept";
    public static String TYPE_NARROWERCONCEPT = "type_narrowerconcept";

    public String NCICBContactURL = null;
    public String terminologySubsetDownloadURL = null;
    public String NCIMBuildInfo = null;

    static String[] hierAssocToParentNodes_ = new String[] { "PAR", "isa", "branch_of", "part_of", "tributary_of" };
    static String[] hierAssocToChildNodes_ = new String[] { "CHD", "hasSubtype" };
    static String[] assocToSiblingNodes_ = new String[] { "SIB" };
    static String[] assocToBTNodes_ = new String[] { "RB", "BT" };
    static String[] assocToNTNodes_ = new String[] { "RN", "NT" };

    static String[] relationshipCategories_ = new String[] { "Parent", "Child", "Broader", "Narrower", "Sibling", "Other"};


    //==================================================================================


    public DataUtils()
    {

    }

/*
    public static List getOntologyList() {
        if(_ontologies == null) setCodingSchemeMap();
        return _ontologies;
    }
*/

/*
    private static void setCodingSchemeMap()
    {
        //if (_ontologies != null) return;
        _ontologies = new ArrayList();
        codingSchemeMap = new HashMap();
        csnv2codingSchemeNameMap = new HashMap();
        csnv2VersionMap = new HashMap();

        try {
            RemoteServerUtil rsu = new RemoteServerUtil();
            //EVSApplicationService lbSvc = rsu.createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();

            CodingSchemeRenderingList csrl = lbSvc.getSupportedCodingSchemes();
            if(csrl == null) System.out.println("csrl is NULL");

            CodingSchemeRendering[] csrs = csrl.getCodingSchemeRendering();
            for (int i=0; i<csrs.length; i++)
            {
                CodingSchemeRendering csr = csrs[i];
                Boolean isActive = csr.getRenderingDetail().getVersionStatus().equals(CodingSchemeVersionStatus.ACTIVE);
                if (isActive != null && isActive.equals(Boolean.TRUE))
                {
                    CodingSchemeSummary css = csr.getCodingSchemeSummary();
                    String formalname = css.getFormalName();
                    String representsVersion = css.getRepresentsVersion();
                    CodingSchemeVersionOrTag vt = new CodingSchemeVersionOrTag();
                    vt.setVersion(representsVersion);


                    CodingScheme scheme = null;
                    try {
                        try {
                            scheme = lbSvc.resolveCodingScheme(formalname, vt);
                        } catch (Exception ex) {
                        }
                        if (scheme != null)
                        {
                            codingSchemeMap.put((Object) formalname, (Object) scheme);

                            String value = formalname + " (version: " + representsVersion + ")";
                            _ontologies.add(new SelectItem(value, value));

                            csnv2codingSchemeNameMap.put(value, formalname);
                            csnv2VersionMap.put(value, representsVersion);

                        }

                    } catch (Exception e) {
                        String urn = css.getCodingSchemeURI();
                        try {
                            scheme = lbSvc.resolveCodingScheme(urn, vt);
                            if (scheme != null)
                            {
                                codingSchemeMap.put((Object) formalname, (Object) scheme);

                                String value = formalname + " (version: " + representsVersion + ")";
                                _ontologies.add(new SelectItem(value, value));

                                csnv2codingSchemeNameMap.put(value, formalname);
                                csnv2VersionMap.put(value, representsVersion);

                            }

                        } catch (Exception ex) {

                            String localname = css.getLocalName();
                            try {
                                scheme = lbSvc.resolveCodingScheme(localname, vt);
                                if (scheme != null)
                                {
                                    codingSchemeMap.put((Object) formalname, (Object) scheme);

                                    String value = formalname + " (version: " + representsVersion + ")";
                                    _ontologies.add(new SelectItem(value, value));

                                    csnv2codingSchemeNameMap.put(value, formalname);
                                    csnv2VersionMap.put(value, representsVersion);

                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

/*
    public static Vector<String> getSupportedAssociationNames(String key)
    {
        if (csnv2codingSchemeNameMap == null)
        {
            setCodingSchemeMap();
            return getSupportedAssociationNames(key);
        }
        String codingSchemeName = (String) csnv2codingSchemeNameMap.get(key);
        if(codingSchemeName == null) return null;
        String version = (String) csnv2VersionMap.get(key);
        if(version == null) return null;
        return getSupportedAssociationNames(codingSchemeName, version);
    }
*/

    public static Vector<String> getSupportedAssociationNames(String codingSchemeName, String version)
    {
        CodingSchemeVersionOrTag vt = new CodingSchemeVersionOrTag();
        if (version != null)
        {
            vt.setVersion(version);
        }

        CodingScheme scheme = null;
        try {
            //RemoteServerUtil rsu = new RemoteServerUtil();
            //EVSApplicationService lbSvc = rsu.createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            scheme = lbSvc.resolveCodingScheme(codingSchemeName, vt);
            if (scheme == null) {
                System.out.println("scheme is NULL");
                return null;
            }

            Vector<String> v = new Vector<String>();
            SupportedAssociation[] assos = scheme.getMappings().getSupportedAssociation();
            for (int i=0; i<assos.length; i++)
            {
                 SupportedAssociation sa = (SupportedAssociation) assos[i];
                 v.add(sa.getLocalId());
            }
            return v;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

/*
    public static Vector<String> getPropertyNameListData(String key)
    {
        if (csnv2codingSchemeNameMap == null)
        {
            setCodingSchemeMap();
        }

        String codingSchemeName = (String) csnv2codingSchemeNameMap.get(key);
        if(codingSchemeName == null)
        {
            return null;
        }
        String version = (String) csnv2VersionMap.get(key);
        if(version == null)
        {
            return null;
        }
        return getPropertyNameListData(codingSchemeName, version);
    }
*/

    public static Vector<String> getPropertyNameListData(String codingSchemeName, String version) {
        CodingSchemeVersionOrTag vt = new CodingSchemeVersionOrTag();
        if (version != null) {
            vt.setVersion(version);
        }
        CodingScheme scheme = null;
        try {
            //RemoteServerUtil rsu = new RemoteServerUtil();
            //EVSApplicationService lbSvc = rsu.createLexBIGService();
LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();

            scheme = lbSvc.resolveCodingScheme(codingSchemeName, vt);
            if (scheme == null) return null;
            Vector<String> propertyNameListData = new Vector<String>();
            SupportedProperty[] properties = scheme.getMappings().getSupportedProperty();
            for (int i=0; i<properties.length; i++)
            {
                SupportedProperty property = properties[i];
                propertyNameListData.add(property.getLocalId());
            }
            return propertyNameListData;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static String getCodingSchemeName(String key)
    {
        return (String) csnv2codingSchemeNameMap.get(key);
    }

    public static String getCodingSchemeVersion(String key)
    {
        return (String) csnv2VersionMap.get(key);
    }

    public static Vector<String> getRepresentationalFormListData(String key)
    {
        String codingSchemeName = (String) csnv2codingSchemeNameMap.get(key);
        if(codingSchemeName == null) return null;
        String version = (String) csnv2VersionMap.get(key);
        if(version == null) return null;
        return getRepresentationalFormListData(codingSchemeName, version);
    }


    public static Vector<String> getRepresentationalFormListData(String codingSchemeName, String version) {
        CodingSchemeVersionOrTag vt = new CodingSchemeVersionOrTag();
        if (version != null) {
            vt.setVersion(version);
        }
        CodingScheme scheme = null;
        try {
            //RemoteServerUtil rsu = new RemoteServerUtil();
            //EVSApplicationService lbSvc = rsu.createLexBIGService();
LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            scheme = lbSvc.resolveCodingScheme(codingSchemeName, vt);
            if (scheme == null) return null;
            Vector<String> propertyNameListData = new Vector<String>();
            SupportedRepresentationalForm[] forms = scheme.getMappings().getSupportedRepresentationalForm();
            if (forms != null)
            {
                for (int i=0; i<forms.length; i++)
                {
                    SupportedRepresentationalForm form = forms[i];
                    propertyNameListData.add(form.getLocalId());
                }
            }
            return propertyNameListData;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static Vector<String> getPropertyQualifierListData(String key)
    {
        String codingSchemeName = (String) csnv2codingSchemeNameMap.get(key);
        if(codingSchemeName == null) return null;
        String version = (String) csnv2VersionMap.get(key);
        if(version == null) return null;
        return getPropertyQualifierListData(codingSchemeName, version);
    }

    public static Vector<String> getPropertyQualifierListData(String codingSchemeName, String version) {
        CodingSchemeVersionOrTag vt = new CodingSchemeVersionOrTag();
        if (version != null) {
            vt.setVersion(version);
        }
        CodingScheme scheme = null;
        try {
            //RemoteServerUtil rsu = new RemoteServerUtil();
            //EVSApplicationService lbSvc = rsu.createLexBIGService();
LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            scheme = lbSvc.resolveCodingScheme(codingSchemeName, vt);
            if (scheme == null) return null;
            Vector<String> propertyQualifierListData = new Vector<String>();
            SupportedPropertyQualifier[] qualifiers = scheme.getMappings().getSupportedPropertyQualifier();
            for (int i=0; i<qualifiers.length; i++)
            {
                SupportedPropertyQualifier qualifier = qualifiers[i];
                propertyQualifierListData.add(qualifier.getLocalId());
            }

            return propertyQualifierListData;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

/*
    public static Vector<String> getSourceListData(String key)
    {
        if (csnv2codingSchemeNameMap == null)
        {
            setCodingSchemeMap();
            return getSourceListData(key);
        }
        String codingSchemeName = (String) csnv2codingSchemeNameMap.get(key);
        if(codingSchemeName == null) return null;
        String version = (String) csnv2VersionMap.get(key);
        if(version == null) return null;
        return getSourceListData(codingSchemeName, version);
    }
*/
    public static Vector<String> getSourceListData(String codingSchemeName, String version) {
		if (sourceListData !=  null) return sourceListData;
        CodingSchemeVersionOrTag vt = new CodingSchemeVersionOrTag();
        if (version != null) {
            vt.setVersion(version);
        }
        CodingScheme scheme = null;
        try {
            //RemoteServerUtil rsu = new RemoteServerUtil();
            //EVSApplicationService lbSvc = rsu.createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            scheme = lbSvc.resolveCodingScheme(codingSchemeName, vt);
            if (scheme == null) return null;
            sourceListData = new Vector<String>();
           	sourceListData.add("ALL");

            //Insert your code here
            SupportedSource[] sources = scheme.getMappings().getSupportedSource();
            for (int i=0; i<sources.length; i++)
            {
                SupportedSource source = sources[i];
                sourceListData.add(source.getLocalId());
            }

            return sourceListData;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }





    public static String int2String(Integer int_obj) {
        if (int_obj == null)
        {
            return null;
        }

        String retstr = Integer.toString(int_obj);
        return retstr;
    }



//==================================================================================================================================
	public static Concept getConceptByCode(String codingSchemeName, String vers, String ltag, String code)
	{
        try {
			LexBIGService lbSvc = new RemoteServerUtil().createLexBIGService();
			if (lbSvc == null)
			{
				System.out.println("lbSvc == null???");
				return null;
			}
			CodingSchemeVersionOrTag versionOrTag = new CodingSchemeVersionOrTag();
			versionOrTag.setVersion(vers);

			ConceptReferenceList crefs =
				createConceptReferenceList(
					new String[] {code}, codingSchemeName);

			CodedNodeSet cns = null;
			try {
				cns = lbSvc.getCodingSchemeConcepts(codingSchemeName, versionOrTag);
				cns = cns.restrictToCodes(crefs);
				ResolvedConceptReferenceList matches = cns.resolveToList(null, null, null, 1);
				if (matches == null)
				{
					System.out.println("Concep not found.");
					return null;
				}
                int count = matches.getResolvedConceptReferenceCount();
				// Analyze the result ...
				if (count == 0) return null;
				if (count > 0) {
                    try {
					    ResolvedConceptReference ref =
							(ResolvedConceptReference) matches.enumerateResolvedConceptReference().nextElement();
						Concept entry = ref.getReferencedEntry();
						return entry;
					} catch (Exception ex1) {
						System.out.println("Exception entry == null");
						return null;
					}
				}
		    } catch (Exception e1) {
				e1.printStackTrace();
				return null;
			}
		 } catch (Exception e) {
			 e.printStackTrace();
			 return null;
		 }
		 return null;
	}


    public static CodedNodeSet restrictToSource(CodedNodeSet cns, String source) {
		if (cns == null) return cns;
		if (source == null || source.compareTo("*") == 0 || source.compareTo("") == 0 || source.compareTo("ALL") == 0) return cns;

		LocalNameList contextList = null;
		LocalNameList sourceLnL = null;
		NameAndValueList qualifierList = null;

		Vector<String> w2 = new Vector<String>();
		w2.add(source);
		sourceLnL = vector2LocalNameList(w2);
		LocalNameList propertyLnL = null;
		CodedNodeSet.PropertyType[] types = new PropertyType[] {PropertyType.PRESENTATION};
		try {
			cns = cns.restrictToProperties(propertyLnL, types, sourceLnL, contextList, qualifierList);
		} catch (Exception ex) {
			System.out.println("restrictToSource throws exceptions.");
			return null;
		}
		return cns;
	}

    public static Concept getConceptByCode(String codingSchemeName, String vers, String ltag, String code, String source)
    {
        try {
            LexBIGService lbSvc = new RemoteServerUtil().createLexBIGService();
            if (lbSvc == null)
            {
                System.out.println("lbSvc == null???");
                return null;
            }

            CodingSchemeVersionOrTag versionOrTag = new CodingSchemeVersionOrTag();
            if (vers != null) versionOrTag.setVersion(vers);

            ConceptReferenceList crefs =
                createConceptReferenceList(
                    new String[] {code}, codingSchemeName);

            CodedNodeSet cns = null;

            try {
                cns = lbSvc.getCodingSchemeConcepts(codingSchemeName, versionOrTag);
            } catch (Exception e1) {
                //e1.printStackTrace();
            }

            cns = cns.restrictToCodes(crefs);
            cns = restrictToSource(cns, source);

            ResolvedConceptReferenceList matches = cns.resolveToList(null, null, null, 1);

            if (matches == null)
            {
                System.out.println("Concep not found.");
                return null;
            }
            // Analyze the result ...
            if (matches.getResolvedConceptReferenceCount() > 0) {
                ResolvedConceptReference ref =
                    (ResolvedConceptReference) matches.enumerateResolvedConceptReference().nextElement();

                Concept entry = ref.getReferencedEntry();

                return entry;
            }
         } catch (Exception e) {
             //e.printStackTrace();
            return null;
         }
         return null;
    }

    public static NameAndValueList createNameAndValueList(String[] names, String[] values)
    {
        NameAndValueList nvList = new NameAndValueList();
        for (int i=0; i<names.length; i++)
        {
            NameAndValue nv = new NameAndValue();
            nv.setName(names[i]);
            if (values != null)
            {
                nv.setContent(values[i]);
            }
            nvList.addNameAndValue(nv);
        }
        return nvList;
    }

    public ResolvedConceptReferenceList getNext(ResolvedConceptReferencesIterator iterator)
    {
        return iterator.getNext();
    }

    public Vector getParentCodes(String scheme, String version, String code) {
        Vector hierarchicalAssoName_vec = getHierarchyAssociationId(scheme, version);
        if (hierarchicalAssoName_vec == null || hierarchicalAssoName_vec.size() == 0)
        {
            return null;
        }
        String hierarchicalAssoName = (String) hierarchicalAssoName_vec.elementAt(0);
        //KLO, 01/23/2009
        //Vector<Concept> superconcept_vec = util.getAssociationSources(scheme, version, code, hierarchicalAssoName);
        Vector superconcept_vec = getAssociationSourceCodes(scheme, version, code, hierarchicalAssoName);
        if (superconcept_vec == null) return null;
        //SortUtils.quickSort(superconcept_vec, SortUtils.SORT_BY_CODE);
        return superconcept_vec;

    }



    public Vector getAssociationSourceCodes(String scheme, String version, String code, String assocName)
    {
        CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
        if (version != null) csvt.setVersion(version);
        ResolvedConceptReferenceList matches = null;
        Vector v = new Vector();
        try {
            //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            CodedNodeGraph cng = lbSvc.getNodeGraph(scheme, csvt, null);

            NameAndValueList nameAndValueList =
                createNameAndValueList(
                    new String[] {assocName}, null);

            NameAndValueList nameAndValueList_qualifier = null;
            cng = cng.restrictToAssociations(nameAndValueList, nameAndValueList_qualifier);

            int maxToReturn = NCImBrowserProperties.maxToReturn;
            matches = cng.resolveAsList(
                    ConvenienceMethods.createConceptReference(code, scheme),
                    false, true, 1, 1, new LocalNameList(), null, null, maxToReturn);

            if (matches.getResolvedConceptReferenceCount() > 0) {
                Enumeration<ResolvedConceptReference> refEnum =
                    matches .enumerateResolvedConceptReference();

                while (refEnum.hasMoreElements()) {
                    ResolvedConceptReference ref = refEnum.nextElement();
                    AssociationList targetof = ref.getTargetOf();
                    Association[] associations = targetof.getAssociation();

                    for (int i = 0; i < associations.length; i++) {
                        Association assoc = associations[i];
                        //KLO
                        assoc = processForAnonomousNodes(assoc);
                        AssociatedConcept[] acl = assoc.getAssociatedConcepts().getAssociatedConcept();
                        for (int j = 0; j < acl.length; j++) {
                            AssociatedConcept ac = acl[j];
                            v.add(ac.getReferencedEntry().getEntityCode());
                        }
                    }
                }
                SortUtils.quickSort(v);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }


    public static ConceptReferenceList createConceptReferenceList(String[] codes, String codingSchemeName)
    {
        if (codes == null)
        {
            return null;
        }
        ConceptReferenceList list = new ConceptReferenceList();
        for (int i = 0; i < codes.length; i++)
        {
            ConceptReference cr = new ConceptReference();
            cr.setCodingSchemeName(codingSchemeName);
            cr.setConceptCode(codes[i]);
            list.addConceptReference(cr);
        }
        return list;
    }

    public Vector getSubconceptCodes(String scheme, String version, String code) { //throws LBException{
        Vector v = new Vector();
        try {
            //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            LexBIGServiceConvenienceMethods lbscm = (LexBIGServiceConvenienceMethods) lbSvc.getGenericExtension("LexBIGServiceConvenienceMethods");
            lbscm.setLexBIGService(lbSvc);

            CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
            csvt.setVersion(version);
            String desc = null;
            try {
                desc = lbscm.createCodeNodeSet(new String[] {code}, scheme, csvt)
                    .resolveToList(null, null, null, 1)
                    .getResolvedConceptReference(0)
                    .getEntityDescription().getContent();

            } catch (Exception e) {
                desc = "<not found>";

            }

            // Iterate through all hierarchies and levels ...
            String[] hierarchyIDs = lbscm.getHierarchyIDs(scheme, csvt);
            for (int k = 0; k < hierarchyIDs.length; k++) {
                String hierarchyID = hierarchyIDs[k];
                AssociationList associations = null;
                associations = null;
                try {
                    associations = lbscm.getHierarchyLevelNext(scheme, csvt, hierarchyID, code, false, null);
                } catch (Exception e) {
                    System.out.println("getSubconceptCodes - Exception lbscm.getHierarchyLevelNext  ");
                    return v;
                }

                for (int i = 0; i < associations.getAssociationCount(); i++) {
                    Association assoc = associations.getAssociation(i);
                    AssociatedConceptList concepts = assoc.getAssociatedConcepts();
                    for (int j = 0; j < concepts.getAssociatedConceptCount(); j++) {
                        AssociatedConcept concept = concepts.getAssociatedConcept(j);
                        String nextCode = concept.getConceptCode();
                        v.add(nextCode);
                    }
                }
            }
        } catch (Exception ex) {
             //ex.printStackTrace();
        }
        return v;
    }


    public Vector getSuperconceptCodes(String scheme, String version, String code) { //throws LBException{
        long ms = System.currentTimeMillis();
        Vector v = new Vector();
        try {
            //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            LexBIGServiceConvenienceMethods lbscm = (LexBIGServiceConvenienceMethods) lbSvc.getGenericExtension("LexBIGServiceConvenienceMethods");
            lbscm.setLexBIGService(lbSvc);
            CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
            csvt.setVersion(version);
            String desc = null;
            try {
                desc = lbscm.createCodeNodeSet(new String[] {code}, scheme, csvt)
                    .resolveToList(null, null, null, 1)
                    .getResolvedConceptReference(0)
                    .getEntityDescription().getContent();
            } catch (Exception e) {
                desc = "<not found>";
            }

            // Iterate through all hierarchies and levels ...
            String[] hierarchyIDs = lbscm.getHierarchyIDs(scheme, csvt);
            for (int k = 0; k < hierarchyIDs.length; k++) {
                String hierarchyID = hierarchyIDs[k];
                AssociationList associations = lbscm.getHierarchyLevelPrev(scheme, csvt, hierarchyID, code, false, null);
                for (int i = 0; i < associations.getAssociationCount(); i++) {
                    Association assoc = associations.getAssociation(i);
                    AssociatedConceptList concepts = assoc.getAssociatedConcepts();
                    for (int j = 0; j < concepts.getAssociatedConceptCount(); j++) {
                        AssociatedConcept concept = concepts.getAssociatedConcept(j);
                        String nextCode = concept.getConceptCode();
                        v.add(nextCode);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Run time (ms): " + (System.currentTimeMillis() - ms));
        }
        return v;
    }

    public Vector getHierarchyAssociationId(String scheme, String version) {

        Vector association_vec = new Vector();
        try {
            //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();

            // Will handle secured ontologies later.
            CodingSchemeVersionOrTag versionOrTag = new CodingSchemeVersionOrTag();
            versionOrTag.setVersion(version);
            CodingScheme cs = lbSvc.resolveCodingScheme(scheme, versionOrTag);
            Mappings mappings = cs.getMappings();
            SupportedHierarchy[] hierarchies = mappings.getSupportedHierarchy();
            java.lang.String[] ids = hierarchies[0].getAssociationNames();

            for (int i=0; i<ids.length; i++)
            {
                if (!association_vec.contains(ids[i])) {
                    association_vec.add(ids[i]);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return association_vec;
    }

    public static String getVocabularyVersionByTag(String codingSchemeName, String ltag)
    {
         if (codingSchemeName == null) return null;
         try {
             //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
             LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
             CodingSchemeRenderingList lcsrl = lbSvc.getSupportedCodingSchemes();
             CodingSchemeRendering[] csra = lcsrl.getCodingSchemeRendering();
             for (int i=0; i<csra.length; i++)
             {
                CodingSchemeRendering csr = csra[i];
                CodingSchemeSummary css = csr.getCodingSchemeSummary();
                if (css.getFormalName().compareTo(codingSchemeName) == 0 || css.getLocalName().compareTo(codingSchemeName) == 0)
                {
                    if (ltag == null) return css.getRepresentsVersion();
                    RenderingDetail rd = csr.getRenderingDetail();
                    CodingSchemeTagList cstl = rd.getVersionTags();
                    java.lang.String[] tags = cstl.getTag();
                    for (int j=0; j<tags.length; j++)
                    {
                        String version_tag = (String) tags[j];
                        if (version_tag.compareToIgnoreCase(ltag) == 0)
                        {
                            return css.getRepresentsVersion();
                        }
                    }
                }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         System.out.println("Version corresponding to tag " + ltag + " is not found " + " in " + codingSchemeName);
         return null;
     }

    public static Vector<String> getVersionListData(String codingSchemeName) {

        Vector<String> v = new Vector();
        try {
            //RemoteServerUtil rsu = new RemoteServerUtil();
            //EVSApplicationService lbSvc = rsu.createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            CodingSchemeRenderingList csrl = lbSvc.getSupportedCodingSchemes();
            if(csrl == null) System.out.println("csrl is NULL");

            CodingSchemeRendering[] csrs = csrl.getCodingSchemeRendering();
            for (int i=0; i<csrs.length; i++)
            {
                CodingSchemeRendering csr = csrs[i];
                Boolean isActive = csr.getRenderingDetail().getVersionStatus().equals(CodingSchemeVersionStatus.ACTIVE);
                if (isActive != null && isActive.equals(Boolean.TRUE))
                {
                    CodingSchemeSummary css = csr.getCodingSchemeSummary();
                    String formalname = css.getFormalName();
                    if (formalname.compareTo(codingSchemeName) == 0)
                    {
                        String representsVersion = css.getRepresentsVersion();
                        v.add(representsVersion);
                    }
                }
            }
       } catch (Exception ex) {

       }
       return v;
   }

   public static String getFileName(String pathname) {
       File file = new File(pathname);
       String filename = file.getName();
       return filename;
   }


    protected static Association processForAnonomousNodes(Association assoc){
        //clone Association except associatedConcepts
        Association temp = new Association();
        temp.setAssociatedData(assoc.getAssociatedData());
        temp.setAssociationName(assoc.getAssociationName());
        temp.setAssociationReference(assoc.getAssociationReference());
        temp.setDirectionalName(assoc.getDirectionalName());
        temp.setAssociatedConcepts(new AssociatedConceptList());

        for(int i = 0; i < assoc.getAssociatedConcepts().getAssociatedConceptCount(); i++)
        {
            //Conditionals to deal with anonymous nodes and UMLS top nodes "V-X"
            //The first three allow UMLS traversal to top node.
            //The last two are specific to owl anonymous nodes which can act like false
            //top nodes.
            if(
                assoc.getAssociatedConcepts().getAssociatedConcept(i).getReferencedEntry() != null &&
                assoc.getAssociatedConcepts().getAssociatedConcept(i).getReferencedEntry().getIsAnonymous() != null &&
                assoc.getAssociatedConcepts().getAssociatedConcept(i).getReferencedEntry().getIsAnonymous() != false &&
                !assoc.getAssociatedConcepts().getAssociatedConcept(i).getConceptCode().equals("@") &&
                !assoc.getAssociatedConcepts().getAssociatedConcept(i).getConceptCode().equals("@@")
                )
            {
                //do nothing
            }
            else{
                temp.getAssociatedConcepts().addAssociatedConcept(assoc.getAssociatedConcepts().getAssociatedConcept(i));
            }
        }
        return temp;
    }




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static LocalNameList vector2LocalNameList(Vector<String> v)
    {
        if (v == null) return null;
        LocalNameList list = new LocalNameList();
        for (int i=0; i<v.size(); i++)
        {
            String vEntry = (String) v.elementAt(i);
            list.addEntry(vEntry);
        }
        return list;
    }

    protected static NameAndValueList createNameAndValueList(Vector names, Vector values)
    {
        if (names == null) return null;
        NameAndValueList nvList = new NameAndValueList();
        for (int i=0; i<names.size(); i++)
        {
            String name = (String) names.elementAt(i);
            String value = (String) values.elementAt(i);
            NameAndValue nv = new NameAndValue();
            nv.setName(name);
            if (value != null)
            {
                nv.setContent(value);
            }
            nvList.addNameAndValue(nv);
        }
        return nvList;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected static CodingScheme getCodingScheme(String codingScheme,
            CodingSchemeVersionOrTag versionOrTag) throws LBException {

        CodingScheme cs = null;
        try {
            //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            cs = lbSvc.resolveCodingScheme(codingScheme, versionOrTag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cs;
    }

    public static Vector<SupportedProperty> getSupportedProperties(CodingScheme cs)
    {
        if (cs == null) return null;
        Vector<SupportedProperty> v = new Vector<SupportedProperty>();
        SupportedProperty[] properties = cs.getMappings().getSupportedProperty();
        for (int i=0; i<properties.length; i++)
        {
             SupportedProperty sp = (SupportedProperty) properties[i];
             v.add(sp);
        }
        return v;
    }

    public static Vector<String> getSupportedPropertyNames(CodingScheme cs)
    {
        Vector w = getSupportedProperties(cs);
        if (w == null) return null;

        Vector<String> v = new Vector<String>();
        for (int i=0; i<w.size(); i++)
        {
             SupportedProperty sp = (SupportedProperty) w.elementAt(i);
             v.add(sp.getLocalId());
        }
        return v;
    }


    public static Vector<String> getSupportedPropertyNames(String codingScheme, String version)
    {
        CodingSchemeVersionOrTag versionOrTag = new CodingSchemeVersionOrTag();
        if (version != null) versionOrTag.setVersion(version);
        try {
            CodingScheme cs = getCodingScheme(codingScheme, versionOrTag);
            return getSupportedPropertyNames(cs);
        } catch (Exception ex) {
        }
        return null;
    }


    public static Vector getPropertyNamesByType(Concept concept, String property_type) {
        Vector v = new Vector();
        org.LexGrid.commonTypes.Property[] properties = null;

        if (property_type.compareToIgnoreCase("GENERIC")== 0)
        {
            properties = concept.getProperty();
        }
        else if (property_type.compareToIgnoreCase("PRESENTATION")== 0)
        {
            properties = concept.getPresentation();
        }
        /*
        else if (property_type.compareToIgnoreCase("INSTRUCTION")== 0)
        {
            properties = concept.getInstruction();
        }
        */
        else if (property_type.compareToIgnoreCase("COMMENT")== 0)
        {
            properties = concept.getComment();
        }
        else if (property_type.compareToIgnoreCase("DEFINITION")== 0)
        {
            properties = concept.getDefinition();
        }

        if (properties == null || properties.length == 0) return v;
        for (int i=0; i<properties.length; i++) {
            Property p = (Property) properties[i];
            //v.add(p.getValue().getContent());
            v.add(p.getPropertyName());
        }
        return v;
    }

    public static Vector getPropertyValues(Concept concept, String property_type, String property_name) {
        Vector v = new Vector();
        org.LexGrid.commonTypes.Property[] properties = null;
        if (property_type.compareToIgnoreCase("GENERIC")== 0)
        {
            properties = concept.getProperty();
        }
        else if (property_type.compareToIgnoreCase("PRESENTATION")== 0)
        {
            properties = concept.getPresentation();
        }
        /*
        else if (property_type.compareToIgnoreCase("INSTRUCTION")== 0)
        {
            properties = concept.getInstruction();
        }
        */
        else if (property_type.compareToIgnoreCase("COMMENT")== 0)
        {
            properties = concept.getComment();
        }
        else if (property_type.compareToIgnoreCase("DEFINITION")== 0)
        {
            properties = concept.getDefinition();
        }
        else
        {

System.out.println("WARNING: property_type not found -- " + property_type);

        }

        if (properties == null || properties.length == 0) return v;
        for (int i=0; i<properties.length; i++) {
            Property p = (Property) properties[i];
            if (property_name.compareTo(p.getPropertyName()) == 0)
            {
                String t = p.getValue().getContent();
                Source[] sources = p.getSource();
                if (sources != null && sources.length > 0) {
                    Source src = sources[0];
                    t = t + "|" + src.getContent();
                }
                v.add(t);
            }
        }
        return v;
    }


//=====================================================================================

    public List getSupportedRoleNames(LexBIGService lbSvc, String scheme, String version)
    {
        CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
        if (version != null) csvt.setVersion(version);

        List list = new ArrayList();
        try {
            CodingScheme cs = lbSvc.resolveCodingScheme(scheme, csvt);
            Relations[] relations = cs.getRelations();
            for (int i=0; i<relations.length; i++)
            {
                Relations relation = relations[i];
                if (relation.getContainerName().compareToIgnoreCase("roles") == 0)
                {
                    org.LexGrid.relations.Association[] asso_array = relation.getAssociation();
                    for (int j=0; j<asso_array.length; j++)
                    {
                        org.LexGrid.relations.Association association = (org.LexGrid.relations.Association) asso_array[j];
                        list.add(association.getAssociationName());
                    }
                }
            }
        } catch (Exception ex) {

        }
        return list;
    }





    public static void sortArray(ArrayList list) {
        String tmp;
        if (list.size() <= 1) return;
        for (int i = 0; i < list.size(); i++) {
           String s1 = (String) list.get(i);
           for (int j = i + 1; j < list.size(); j++) {
              String s2 = (String) list.get(j);
              if(s1.compareToIgnoreCase(s2 ) > 0 ) {
                 tmp = s1;
                 list.set(i, s2);
                 list.set(j, tmp);
              }
           }
        }
    }


    public static void sortArray(String[] strArray) {
        String tmp;
        if (strArray.length <= 1) return;
        for (int i = 0; i < strArray.length; i++) {
           for (int j = i + 1; j < strArray.length; j++) {
              if(strArray[i].compareToIgnoreCase(strArray[j] ) > 0 ) {
                 tmp = strArray[i];
                 strArray[i] = strArray[j];
                 strArray[j] = tmp;
              }
           }
        }
    }

    public String[] getSortedKeys(HashMap map)
    {
        if (map == null) return null;
        Set keyset = map.keySet();
        String[] names = new String[keyset.size()];
        Iterator it = keyset.iterator();
        int i = 0;
        while (it.hasNext())
        {
            String s = (String) it.next();
            names[i] = s;
            i++;
        }
        sortArray(names);
        return names;
    }



    public String getPreferredName(Concept c) {

        Presentation[] presentations = c.getPresentation();
        for (int i=0; i<presentations.length; i++)
        {
            Presentation p = presentations[i];
            if (p.getPropertyName().compareTo("Preferred_Name") == 0)
            {
                return p.getValue().getContent();
            }
        }
        return null;
    }

    public HashMap getRelationshipHashMap(String scheme, String version, String code)
    {
		return getRelationshipHashMap(scheme, version, code, null);
	}


    public HashMap getRelationshipHashMap(String scheme, String version, String code, String sab)
    {
        //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
        LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();

        CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
        if (version != null) csvt.setVersion(version);

        // Perform the query ...
        ResolvedConceptReferenceList matches = null;

        List list = new ArrayList();//getSupportedRoleNames(lbSvc, scheme, version);

        ArrayList roleList = new ArrayList();
        ArrayList associationList = new ArrayList();
        ArrayList superconceptList = new ArrayList();
        ArrayList siblingList = new ArrayList();
        ArrayList subconceptList = new ArrayList();
        ArrayList btList = new ArrayList();
        ArrayList ntList = new ArrayList();

        Vector parent_asso_vec = new Vector(Arrays.asList(hierAssocToParentNodes_));
        Vector child_asso_vec = new Vector(Arrays.asList(hierAssocToChildNodes_));
        Vector sibling_asso_vec = new Vector(Arrays.asList(assocToSiblingNodes_));
        Vector bt_vec = new Vector(Arrays.asList(assocToBTNodes_));
        Vector nt_vec = new Vector(Arrays.asList(assocToNTNodes_));

        HashMap map = new HashMap();
        try {
            CodedNodeGraph cng = lbSvc.getNodeGraph(scheme, csvt, null);

            //ResolvedConceptReferenceList branch = cng.resolveAsList(focus, associationsNavigatedFwd,
            //      !associationsNavigatedFwd, -1, 2, noopList_, null, null, null, -1, false);

            if (sab != null) {
				cng = cng.restrictToAssociations(null, Constructors.createNameAndValueList(sab, "Source"));
			}

            int maxToReturn = NCImBrowserProperties.maxToReturn;
            matches = cng.resolveAsList(
                    ConvenienceMethods.createConceptReference(code, scheme),
                    //true, false, 1, 1, noopList_, null, null, null, -1, false);
                    true, false, 1, 1, noopList_, null, null, null, maxToReturn, false);



            if (matches.getResolvedConceptReferenceCount() > 0) {
                Enumeration<ResolvedConceptReference> refEnum =
                    matches .enumerateResolvedConceptReference();

                while (refEnum.hasMoreElements()) {
                    ResolvedConceptReference ref = refEnum.nextElement();
                    AssociationList sourceof = ref.getSourceOf();
                    Association[] associations = sourceof.getAssociation();

                    for (int i = 0; i < associations.length; i++) {
                        Association assoc = associations[i];
                        String associationName = assoc.getAssociationName();
                        //System.out.println("\t" + assoc.getAssociationName());

                        boolean isRole = false;
                        if (list.contains(associationName))
                        {
                            isRole = true;
                        }

                        AssociatedConcept[] acl = assoc.getAssociatedConcepts().getAssociatedConcept();
                        for (int j = 0; j < acl.length; j++) {
                            AssociatedConcept ac = acl[j];
                            EntityDescription ed = ac.getEntityDescription();

                            String name = "No Description";
                            if (ed != null) name = ed.getContent();
                            String pt = name;
                            if (associationName.compareToIgnoreCase("equivalentClass") != 0) {
                                String s = associationName + "|" + pt + "|" + ac.getConceptCode();
                                if (!parent_asso_vec.contains(associationName) &&
                                    !child_asso_vec.contains(associationName)) {
									if (sibling_asso_vec.contains(associationName)) {
									    siblingList.add(s);
									} else if (bt_vec.contains(associationName)) {
									    btList.add(s);
									} else if (nt_vec.contains(associationName)) {
									    ntList.add(s);
									} else {
										associationList.add(s);
									}
							    }
                            }
                        }
                    }
                }
            }


            if (roleList.size() > 0) {
                SortUtils.quickSort(roleList);
		    }

            if (associationList.size() > 0) {
				//KLO, 052909
				associationList = removeRedundantRelationships(associationList, "RO");
                SortUtils.quickSort(associationList);
            }

            if (siblingList.size() > 0) {
                SortUtils.quickSort(siblingList);
            }

            if (btList.size() > 0) {
                SortUtils.quickSort(btList);
            }

            if (ntList.size() > 0) {
                SortUtils.quickSort(ntList);
            }

            map.put(TYPE_ROLE, roleList);
            map.put(TYPE_ASSOCIATION, associationList);
            map.put(TYPE_SIBLINGCONCEPT, siblingList);
            map.put(TYPE_BROADERCONCEPT, btList);
            map.put(TYPE_NARROWERCONCEPT, ntList);

            Vector superconcept_vec = getSuperconcepts(scheme, version, code);
            for (int i=0; i<superconcept_vec.size(); i++)
            {
                Concept c = (Concept) superconcept_vec.elementAt(i);
                //String pt = getPreferredName(c);
                String pt = c.getEntityDescription().getContent();
                superconceptList.add(pt + "|" + c.getEntityCode());
            }

            SortUtils.quickSort(superconceptList);
            map.put(TYPE_SUPERCONCEPT, superconceptList);


            Vector subconcept_vec = getSubconcepts(scheme, version, code);
            for (int i=0; i<subconcept_vec.size(); i++)
            {
                Concept c = (Concept) subconcept_vec.elementAt(i);
                //String pt = getPreferredName(c);
                String pt = c.getEntityDescription().getContent();
                subconceptList.add(pt + "|" + c.getEntityCode());
            }
            SortUtils.quickSort(subconceptList);
            map.put(TYPE_SUBCONCEPT, subconceptList);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }

    public Vector getSuperconcepts(String scheme, String version, String code)
    {
        return getAssociationSources(scheme, version, code, hierAssocToChildNodes_);
    }


    public Vector getAssociationSources(String scheme, String version, String code, String[] assocNames)
    {
        CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
        if (version != null) csvt.setVersion(version);
        ResolvedConceptReferenceList matches = null;
        Vector v = new Vector();
        try {
            //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            CodedNodeGraph cng = lbSvc.getNodeGraph(scheme, csvt, null);

            NameAndValueList nameAndValueList = ConvenienceMethods.createNameAndValueList(assocNames);

            NameAndValueList nameAndValueList_qualifier = null;
            cng = cng.restrictToAssociations(nameAndValueList, nameAndValueList_qualifier);
            ConceptReference graphFocus = ConvenienceMethods.createConceptReference(code, scheme);

            boolean resolveForward = false;
            boolean resolveBackward = true;

            int resolveAssociationDepth = 1;
            int maxToReturn = -1;

            ResolvedConceptReferencesIterator iterator = codedNodeGraph2CodedNodeSetIterator(
                            cng,
                            graphFocus,
                            resolveForward,
                            resolveBackward,
                            resolveAssociationDepth,
                            maxToReturn);

            v = resolveIterator(iterator, maxToReturn, code);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    public Vector getSubconcepts(String scheme, String version, String code)
    {
        return getAssociationTargets(scheme, version, code, hierAssocToChildNodes_);
    }

    public Vector getAssociationTargets(String scheme, String version, String code, String[] assocNames)
    {
        CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
        if (version != null) csvt.setVersion(version);
        ResolvedConceptReferenceList matches = null;
        Vector v = new Vector();
        try {
            //EVSApplicationService lbSvc = new RemoteServerUtil().createLexBIGService();
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            CodedNodeGraph cng = lbSvc.getNodeGraph(scheme, csvt, null);
            NameAndValueList nameAndValueList = ConvenienceMethods.createNameAndValueList(assocNames);

            NameAndValueList nameAndValueList_qualifier = null;
            cng = cng.restrictToAssociations(nameAndValueList, nameAndValueList_qualifier);
            ConceptReference graphFocus = ConvenienceMethods.createConceptReference(code, scheme);

            boolean resolveForward = true;
            boolean resolveBackward = false;

            int resolveAssociationDepth = 1;
            int maxToReturn = -1;

            ResolvedConceptReferencesIterator iterator = codedNodeGraph2CodedNodeSetIterator(
                            cng,
                            graphFocus,
                            resolveForward,
                            resolveBackward,
                            resolveAssociationDepth,
                            maxToReturn);

            v = resolveIterator(iterator, maxToReturn, code);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }

    public ResolvedConceptReferencesIterator codedNodeGraph2CodedNodeSetIterator(
                            CodedNodeGraph cng,
                            ConceptReference graphFocus,
                            boolean resolveForward,
                            boolean resolveBackward,
                            int resolveAssociationDepth,
                            int maxToReturn) {
         CodedNodeSet cns = null;
         try {
             cns = cng.toNodeList(graphFocus,
                             resolveForward,
                             resolveBackward,
                             resolveAssociationDepth,
                             maxToReturn);

             if (cns == null)
             {
                 System.out.println("cng.toNodeList returns null???");
                 return null;
             }


             SortOptionList sortCriteria = null;
                //Constructors.createSortOptionList(new String[]{"matchToQuery", "code"});

             LocalNameList propertyNames = null;
             CodedNodeSet.PropertyType[] propertyTypes = null;
             ResolvedConceptReferencesIterator iterator = null;
             try {
                 iterator = cns.resolve(sortCriteria, propertyNames, propertyTypes);
             } catch (Exception e) {
                 e.printStackTrace();
             }

             if(iterator == null)
             {
                 System.out.println("cns.resolve returns null???");
             }
             return iterator;

         } catch (Exception ex) {
             ex.printStackTrace();
             return null;
         }
    }

    public Vector resolveIterator(ResolvedConceptReferencesIterator iterator, int maxToReturn)
    {
        return resolveIterator(iterator, maxToReturn, null);
    }


    public Vector resolveIterator(ResolvedConceptReferencesIterator iterator, int maxToReturn, String code)
    {
        Vector v = new Vector();
        if (iterator == null)
        {
            System.out.println("No match.");
            return v;
        }
        try {
            int iteration = 0;
            while (iterator.hasNext())
            {
                iteration++;
                iterator = iterator.scroll(maxToReturn);
                ResolvedConceptReferenceList rcrl = iterator.getNext();
                ResolvedConceptReference[] rcra = rcrl.getResolvedConceptReference();
                for (int i=0; i<rcra.length; i++)
                {
                    ResolvedConceptReference rcr = rcra[i];
                    org.LexGrid.concepts.Concept ce = rcr.getReferencedEntry();
                    if (code == null)
                    {
                        v.add(ce);
                    }
                    else
                    {
                        if (ce.getEntityCode().compareTo(code) != 0) v.add(ce);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static Vector<String> parseData(String line, String tab)
    {
        Vector data_vec = new Vector();
        StringTokenizer st = new StringTokenizer(line, tab);
        while (st.hasMoreTokens()) {
            String value = st.nextToken();
            if (value.compareTo("null") == 0) value = " ";
            data_vec.add(value);
        }
        return data_vec;
    }

    public static String getHyperlink(String url, String codingScheme, String code)
    {
        codingScheme = codingScheme.replace(" ", "%20");
        String link = url + "/ConceptReport.jsp?dictionary=" + codingScheme + "&code=" + code;
        return link;
    }

    public List getHierarchyRoots(
        String scheme,
        String version,
        String hierarchyID) throws LBException
    {
        CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
        if (version != null) csvt.setVersion(version);
        return getHierarchyRoots(scheme, csvt, hierarchyID);
    }



    public List getHierarchyRoots(
        String scheme,
        CodingSchemeVersionOrTag csvt,
        String hierarchyID) throws LBException
    {
        int maxDepth = 1;
        LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
        LexBIGServiceConvenienceMethods lbscm = (LexBIGServiceConvenienceMethods) lbSvc.getGenericExtension("LexBIGServiceConvenienceMethods");
        lbscm.setLexBIGService(lbSvc);
        ResolvedConceptReferenceList roots = lbscm.getHierarchyRoots(scheme, csvt, hierarchyID);
        List list = ResolvedConceptReferenceList2List(roots);
        SortUtils.quickSort(list);
        return list;
    }

    public List getSourceHierarchyRoots(
        String scheme,
        CodingSchemeVersionOrTag csvt,
        String sab) throws LBException
    {
		/*
        int maxDepth = 1;
        LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
        LexBIGServiceConvenienceMethods lbscm = (LexBIGServiceConvenienceMethods) lbSvc.getGenericExtension("LexBIGServiceConvenienceMethods");
        lbscm.setLexBIGService(lbSvc);
        ResolvedConceptReferenceList roots = lbscm.getHierarchyRoots(scheme, csvt, hierarchyID);
        */

        ResolvedConceptReferenceList roots = null;
        try {
           roots = new MetaTreeUtils().getSourceRoots(sab);
		   List list = ResolvedConceptReferenceList2List(roots);
		   SortUtils.quickSort(list);
		   return list;
	    } catch (Exception ex) {

		}
		return new ArrayList();
    }


    public List ResolvedConceptReferenceList2List(ResolvedConceptReferenceList rcrl)
    {
        ArrayList list = new ArrayList();
        for (int i=0; i<rcrl.getResolvedConceptReferenceCount(); i++)
        {
            ResolvedConceptReference rcr = rcrl.getResolvedConceptReference(i);
            list.add(rcr);
        }
        return list;
    }

    public static Vector getSynonyms(String scheme, String version, String tag, String code, String sab) {
        Concept concept = getConceptByCode(scheme, version, tag, code);
        return getSynonyms(concept, sab);
    }


    public static Vector getSynonyms(String scheme, String version, String tag, String code) {
        Concept concept = getConceptByCode(scheme, version, tag, code);
        return getSynonyms(concept, null);
    }

    public static Vector getSynonyms(Concept concept) {
		return getSynonyms(concept, null);
    }

    public static Vector getSynonyms(Concept concept, String sab) {

        if (concept == null) return null;
        Vector v = new Vector();
        Presentation[] properties = concept.getPresentation();
        int n = 0;
        for (int i=0; i<properties.length; i++)
        {
            Presentation p = properties[i];
            // name
			String term_name = p.getValue().getContent();
			String term_type = "null";
			String term_source = "null";
			String term_source_code = "null";

            // source-code
			PropertyQualifier[] qualifiers = p.getPropertyQualifier();
			if (qualifiers != null)
			{
				for (int j=0; j<qualifiers.length; j++)
				{
					PropertyQualifier q = qualifiers[j];
					String qualifier_name = q.getPropertyQualifierName();
					String qualifier_value = q.getValue().getContent();
					if (qualifier_name.compareTo("source-code") == 0)
					{
						term_source_code = qualifier_value;
						break;
					}
				}
			}
			// term type
			term_type = p.getRepresentationalForm();

			// source
			Source[] sources = p.getSource();
			if (sources != null && sources.length > 0)
			{
				Source src = sources[0];
				term_source = src.getContent();
			}
			String t = null;
			if (sab == null) {
			    t = term_name + "|" + term_type + "|" + term_source + "|" + term_source_code;
			    v.add(t);
			} else if (term_source != null && sab.compareTo(term_source) == 0) {
				t = term_name + "|" + term_type + "|" + term_source + "|" + term_source_code;
				v.add(t);
			}
        }
        SortUtils.quickSort(v);
        return v;
	}

    public String getNCICBContactURL()
    {
        if (NCICBContactURL != null)
        {
            return NCICBContactURL;
        }
        String default_url = "ncicb@pop.nci.nih.gov";
        NCImBrowserProperties properties = null;
        try {
            properties = NCImBrowserProperties.getInstance();
            NCICBContactURL = properties.getProperty(NCImBrowserProperties.NCICB_CONTACT_URL);
            if (NCICBContactURL == null)
            {
                NCICBContactURL = default_url;
            }
        } catch (Exception ex) {

        }

        System.out.println("getNCICBContactURL returns " + NCICBContactURL);
        return NCICBContactURL;
    }

    public String getTerminologySubsetDownloadURL()
    {
        NCImBrowserProperties properties = null;
        try {
            properties = NCImBrowserProperties.getInstance();
            terminologySubsetDownloadURL = properties.getProperty(NCImBrowserProperties.TERMINOLOGY_SUBSET_DOWNLOAD_URL);
        } catch (Exception ex) {

        }
        return terminologySubsetDownloadURL;
    }

    public String getNCIMBuildInfo()
    {
        if (NCIMBuildInfo != null)
        {
            return NCIMBuildInfo;
        }
        String default_info = "N/A";
        NCImBrowserProperties properties = null;
        try {
            properties = NCImBrowserProperties.getInstance();
            NCIMBuildInfo = properties.getProperty(NCImBrowserProperties.NCIM_BUILD_INFO);
            if (NCIMBuildInfo == null)
            {
                NCIMBuildInfo = default_info;
            }
        } catch (Exception ex) {

        }

        System.out.println("getNCIMBuildInfo returns " + NCIMBuildInfo);
        return NCIMBuildInfo;
    }


    public static Vector<String> getMatchTypeListData(String codingSchemeName, String version) {
        Vector<String> v = new Vector<String>();
        v.add("String");
        v.add("Code");
        v.add("CUI");
        return v;
    }

    public static Vector getSources(String scheme, String version, String tag, String code) {
		Vector sources = getSynonyms(scheme, version, tag, code);
		//GLIOBLASTOMA MULTIFORME|DI|DXP|U000721
		HashSet hset = new HashSet();
		Vector source_vec = new Vector();
		for (int i=0; i<sources.size(); i++)
		{
			String s = (String) sources.elementAt(i);
			Vector ret_vec = DataUtils.parseData(s, "|");
			String name = (String) ret_vec.elementAt(0);
			String type = (String) ret_vec.elementAt(1);
			String src = (String) ret_vec.elementAt(2);
			String srccode = (String) ret_vec.elementAt(3);
			if (!hset.contains(src)) {
				hset.add(src);
				source_vec.add(src);
			}
		}
        SortUtils.quickSort(source_vec);
        return source_vec;
	}


	public static boolean containSource(Vector sources, String source) {
		if (sources == null || sources.size() == 0) return false;
		String s = null;
		for (int i=0; i<sources.size(); i++) {
			s = (String) sources.elementAt(i);
			if (s.compareTo(source) == 0) return true;
		}
		return false;
	}


    public Vector getAssociatedConcepts(String scheme, String version, String code, String sab) {
        CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
        if (version != null) csvt.setVersion(version);
        ResolvedConceptReferenceList matches = null;
        Vector v = new Vector();
        try {
            LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();
            CodedNodeGraph cng = lbSvc.getNodeGraph(scheme, csvt, null);
            //NameAndValueList nameAndValueList = ConvenienceMethods.createNameAndValueList(assocNames);

            NameAndValueList nameAndValueList_qualifier = null;
            cng = cng.restrictToAssociations(null, Constructors.createNameAndValueList(sab, "Source"));
            ConceptReference graphFocus = ConvenienceMethods.createConceptReference(code, scheme);

            boolean resolveForward = true;
            boolean resolveBackward = true;

            int resolveAssociationDepth = 1;
            int maxToReturn = -1;

            ResolvedConceptReferencesIterator iterator = codedNodeGraph2CodedNodeSetIterator(
                            cng,
                            graphFocus,
                            resolveForward,
                            resolveBackward,
                            resolveAssociationDepth,
                            maxToReturn);

            v = resolveIterator(iterator, maxToReturn, code);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SortUtils.quickSort(v);
        return v;

	}


    protected boolean isValidForSAB(AssociatedConcept ac, String sab) {
        for (NameAndValue qualifier : ac.getAssociationQualifiers().getNameAndValue())
            if ("Source".equalsIgnoreCase(qualifier.getContent())
                    && sab.equalsIgnoreCase(qualifier.getName()))
                return true;
        return false;
    }

    public Vector sortSynonyms(Vector synonyms, String sortBy) {
		if (sortBy == null) sortBy = "name";
		HashMap hmap = new HashMap();
		Vector key_vec = new Vector();
		String delim = "  ";
        for (int n=0; n<synonyms.size(); n++)
        {
			String s = (String) synonyms.elementAt(n);
            Vector synonym_data = DataUtils.parseData(s, "|");
            String term_name = (String) synonym_data.elementAt(0);
            String term_type = (String) synonym_data.elementAt(1);
            String term_source = (String) synonym_data.elementAt(2);
            String term_source_code = (String) synonym_data.elementAt(3);
            String key = term_name + delim + term_source + delim + term_source_code + delim + term_type;
            if (sortBy.compareTo("type") == 0) key = term_type + delim + term_name + delim + term_source + delim + term_source_code;
            if (sortBy.compareTo("source") == 0) key = term_source + delim + term_name + delim + term_source_code + delim + term_type;
            if (sortBy.compareTo("code") == 0) key = term_source_code + delim + term_name + delim + term_source + delim + term_type;

            hmap.put(key, s);
            key_vec.add(key);
		}
		key_vec = SortUtils.quickSort(key_vec);
		Vector v = new Vector();
		for (int i=0; i<key_vec.size(); i++) {
			String s = (String) key_vec.elementAt(i);
			v.add((String) hmap.get(s));
		}
		return v;
	}



/*
    public Vector sortSynonymDataByRel(Vector synonyms) {
        Vector parent_asso_vec = new Vector(Arrays.asList(hierAssocToParentNodes_));
        Vector child_asso_vec = new Vector(Arrays.asList(hierAssocToChildNodes_));
        Vector sibling_asso_vec = new Vector(Arrays.asList(assocToSiblingNodes_));
        Vector bt_vec = new Vector(Arrays.asList(assocToBTNodes_));
        Vector nt_vec = new Vector(Arrays.asList(assocToNTNodes_));

		HashMap hmap = new HashMap();
		Vector key_vec = new Vector();
		String key = null;

        for (int n=0; n<synonyms.size(); n++)
        {
            String s = (String) synonyms.elementAt(n);
            Vector synonym_data = DataUtils.parseData(s, "|");
            String term_name = (String) synonym_data.elementAt(0);
            String term_type = (String) synonym_data.elementAt(1);
            String term_source = (String) synonym_data.elementAt(2);
            String term_source_code = (String) synonym_data.elementAt(3);
            String cui = (String) synonym_data.elementAt(4);
            String rel = (String) synonym_data.elementAt(5);

			String category = "0";
			if (parent_asso_vec.contains(rel)) category = "1";
			else if (child_asso_vec.contains(rel)) category = "2";
			else if (bt_vec.contains(rel)) category = "3";
			else if (nt_vec.contains(rel)) category = "4";
			else if (sibling_asso_vec.contains(rel)) category = "5";
			else category = "6";

			key = category + rel + term_name + term_source_code;
            hmap.put(key, s);
            key_vec.add(key);
		}
		key_vec = SortUtils.quickSort(key_vec);
		Vector v = new Vector();
		for (int i=0; i<key_vec.size(); i++) {
			String s = (String) key_vec.elementAt(i);
			v.add((String) hmap.get(s));
		}
		return v;
	}
*/

    public HashMap getAssociatedConceptsHashMap(String scheme, String version, String code, String sab)
    {
        HashMap hmap = new HashMap();
        LexBIGService lbSvc = RemoteServerUtil.createLexBIGService();

        CodingSchemeVersionOrTag csvt = new CodingSchemeVersionOrTag();
        if (version != null) csvt.setVersion(version);

        // Perform the query ...
        ResolvedConceptReferenceList matches = null;

        List list = new ArrayList();//getSupportedRoleNames(lbSvc, scheme, version);
        HashMap map = new HashMap();
        try {
            CodedNodeGraph cng = lbSvc.getNodeGraph(scheme, csvt, null);
            if (sab != null) {
				cng = cng.restrictToAssociations(null, Constructors.createNameAndValueList(sab, "Source"));
			}
/*
 ResolvedConceptReferenceList 	resolveAsList(ConceptReference graphFocus, boolean resolveForward, boolean resolveBackward, int resolveCodedEntryDepth,
 int resolveAssociationDepth, LocalNameList propertyNames, CodedNodeSet.PropertyType[] propertyTypes,
 SortOptionList sortOptions, LocalNameList filterOptions, int maxToReturn)  */

            CodedNodeSet.PropertyType[] propertyTypes = new CodedNodeSet.PropertyType[1];
            propertyTypes[0] = PropertyType.PRESENTATION;

            int maxToReturn = NCImBrowserProperties.maxToReturn;

            matches = cng.resolveAsList(
                    ConvenienceMethods.createConceptReference(code, scheme),
                    //true, false, 1, 1, null, propertyTypes, null, null, -1, false);
                    true, false, 1, 1, null, propertyTypes, null, null, maxToReturn, false);

            if (matches.getResolvedConceptReferenceCount() > 0) {
                Enumeration<ResolvedConceptReference> refEnum =
                    matches .enumerateResolvedConceptReference();

                while (refEnum.hasMoreElements()) {
                    ResolvedConceptReference ref = refEnum.nextElement();
                    AssociationList sourceof = ref.getSourceOf();
                    Association[] associations = sourceof.getAssociation();

                    for (int i = 0; i < associations.length; i++) {
                        Association assoc = associations[i];
                        String associationName = assoc.getAssociationName();
                        Vector v = new Vector();
                        AssociatedConcept[] acl = assoc.getAssociatedConcepts().getAssociatedConcept();
                        for (int j = 0; j < acl.length; j++) {
                            AssociatedConcept ac = acl[j];
                            if (associationName.compareToIgnoreCase("equivalentClass") != 0) {
								v.add(ac);
							}
						}
						hmap.put(associationName, v);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hmap;
    }

    private String findRepresentativeTerm(Concept c, String sab) {
		Vector synonyms = getSynonyms(c, sab);
		if(synonyms == null || synonyms.size() == 0) return null;
		return NCImBrowserProperties.getHighestTermGroupRank(synonyms);
	}


    // Method for populating By Source tab relationships table
	public Vector getNeighborhoodSynonyms(String scheme, String version, String code, String sab) {
        Vector parent_asso_vec = new Vector(Arrays.asList(hierAssocToParentNodes_));
        Vector child_asso_vec = new Vector(Arrays.asList(hierAssocToChildNodes_));
        Vector sibling_asso_vec = new Vector(Arrays.asList(assocToSiblingNodes_));
        Vector bt_vec = new Vector(Arrays.asList(assocToBTNodes_));
        Vector nt_vec = new Vector(Arrays.asList(assocToNTNodes_));

		Vector w = new Vector();
		HashSet hset = new HashSet();

		long ms = System.currentTimeMillis();
        String action = "Retrieving distance-one relationships from the server";
		HashMap hmap = getAssociatedConceptsHashMap(scheme, version, code, sab);
		Debug.println("Run time (ms) for " + action + " " + (System.currentTimeMillis() - ms));
		DBG.debugDetails((System.currentTimeMillis() - ms), action, "getNeighborhoodSynonyms");

		Set keyset = hmap.keySet();
		Iterator it = keyset.iterator();
		HashSet rel_hset = new HashSet();

		long ms_categorization_delay = 0;
		long ms_categorization;

		long ms_find_highest_rank_atom_delay = 0;
		long ms_find_highest_rank_atom;

		long ms_remove_RO_delay = 0;
		long ms_remove_RO;

		long ms_all_delay = 0;
		long ms_all;

		ms_all = System.currentTimeMillis();

		while (it.hasNext())
		{
			ms_categorization = System.currentTimeMillis();
			String rel = (String) it.next();
			String category = "Other";
			if (parent_asso_vec.contains(rel)) category = "Parent";
			else if (child_asso_vec.contains(rel)) category = "Child";
			else if (bt_vec.contains(rel)) category = "Broader";
			else if (nt_vec.contains(rel)) category = "Narrower";
			else if (sibling_asso_vec.contains(rel)) category = "Sibling";

			ms_categorization_delay = ms_categorization_delay + (System.currentTimeMillis() - ms_categorization);
			Vector v = (Vector) hmap.get(rel);

            // For each related concept:
			for (int i=0; i<v.size(); i++) {
				AssociatedConcept ac = (AssociatedConcept) v.elementAt(i);
				EntityDescription ed = ac.getEntityDescription();
				Concept c = ac.getReferencedEntry();
				if (!hset.contains(c.getEntityCode())) {
					hset.add(c.getEntityCode());
					// Find the highest ranked atom data
					ms_find_highest_rank_atom = System.currentTimeMillis();
					String t = findRepresentativeTerm(c, sab);
					ms_find_highest_rank_atom_delay = ms_find_highest_rank_atom_delay + (System.currentTimeMillis() - ms_find_highest_rank_atom);

					t = t + "|" + c.getEntityCode() + "|" + rel + "|" + category;
					w.add(t);

                    // Temporarily save non-RO other relationships
					if(category.compareTo("Other") == 0 && category.compareTo("RO") != 0) {
						if (rel_hset.contains(c.getEntityCode())) {
							rel_hset.add(c.getEntityCode());
						}
					}
			    }
			}
		}

        Vector u = new Vector();
        // Remove redundant RO relationships
		for (int i=0; i<w.size(); i++) {
			String s = (String) w.elementAt(i);
			Vector<String> v = parseData(s, "|");

			if (v.size() >=5) {
				String associationName = v.elementAt(5);
				if (associationName.compareTo("RO") != 0) {
					u.add(s);
				} else {
					String associationTargetCode = v.elementAt(4);
					if (!rel_hset.contains(associationTargetCode)) {
						u.add(s);
					}
				}
		    }
		}
		ms_all_delay = System.currentTimeMillis() - ms_all;

		action = "categorizing relationships into six categories";
		Debug.println("Run time (ms) for " + action + " " + ms_categorization_delay);
		DBG.debugDetails(ms_categorization_delay, action, "getNeighborhoodSynonyms");

		action = "finding highest ranked atoms";
		Debug.println("Run time (ms) for " + action + " " + ms_find_highest_rank_atom_delay);
		DBG.debugDetails(ms_find_highest_rank_atom_delay, action, "getNeighborhoodSynonyms");

		ms_remove_RO_delay = ms_all_delay - ms_categorization_delay - ms_find_highest_rank_atom_delay;
		action = "removing redundant RO relationships";
		Debug.println("Run time (ms) for " + action + " " + ms_remove_RO_delay);
        DBG.debugDetails(ms_remove_RO_delay, action, "getNeighborhoodSynonyms");

        // Initial sort (refer to sortSynonymData method for sorting by a specific column)

		long ms_sort_delay = System.currentTimeMillis();
		SortUtils.quickSort(u);
		action = "initial sorting";
		Debug.println("Run time (ms) for " + action + " " + (System.currentTimeMillis() - ms_sort_delay));
		return u;

     }

     public static String getRelationshipCode(String id) {
		 if (id.compareTo("Parent") == 0) return "1";
		 else if (id.compareTo("Child") == 0) return "2";
		 else if (id.compareTo("Broader") == 0) return "3";
		 else if (id.compareTo("Narrower") == 0) return "4";
		 else if (id.compareTo("Sibling") == 0) return "5";
		 else return "6";
	 }

    public static boolean containsAllUpperCaseChars(String s) {
		for (int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (ch < 65 || ch > 90) return false;
		}
		return true;
	}

    public static Vector sortSynonymData(Vector synonyms, String sortBy) {
        DYEE.header();
        DYEE.printMethod();
        DYEE.printList("synonyms", synonyms);
        DYEE.printVar("sortBy", sortBy);
		if (sortBy == null) sortBy = "name";
		HashMap hmap = new HashMap();
		Vector key_vec = new Vector();
		String delim = "  ";
        for (int n=0; n<synonyms.size(); n++)
        {
            String s = (String) synonyms.elementAt(n);
            Vector synonym_data = DataUtils.parseData(s, "|");
            String term_name = (String) synonym_data.elementAt(0);
            String term_type = (String) synonym_data.elementAt(1);
            String term_source = (String) synonym_data.elementAt(2);
            String term_source_code = (String) synonym_data.elementAt(3);
            String cui = (String) synonym_data.elementAt(4);
            String rel = (String) synonym_data.elementAt(5);
            String rel_type = (String) synonym_data.elementAt(6);

            String rel_type_str = getRelationshipCode(rel_type);
            String key = term_name + delim + term_type + delim + term_source + delim + term_source_code +delim + cui + delim + rel + delim + rel_type_str;
            if (sortBy.compareTo("type") == 0) key = term_type +delim + term_name + delim + term_source + delim + term_source_code + delim + cui + delim + rel + delim + rel_type_str;
            if (sortBy.compareTo("source") == 0) key = term_source +delim + term_name + delim + term_type + delim + cui + delim + rel + delim + rel_type_str;
            if (sortBy.compareTo("code") == 0) key = term_source_code + delim + term_name + delim + term_type + delim + term_source + delim + cui + delim + rel + delim + rel_type_str;
            if (sortBy.compareTo("rel") == 0) {
				String rel_key = rel;
				if (containsAllUpperCaseChars(rel)) rel_key = "|";
				 key = rel + term_name + delim + term_type + delim + term_source + delim + term_source_code +delim + cui + delim + rel_type_str;
		    }
            if (sortBy.compareTo("cui") == 0) key = cui + term_name + delim + term_type + delim + term_source + delim + term_source_code +delim + rel + delim + rel_type_str;
            if (sortBy.compareTo("rel_type") == 0) key = rel_type_str + delim + rel + delim +  term_name + delim + term_type + delim + term_source + delim + term_source_code + delim + cui;
            hmap.put(key, s);
            key_vec.add(key);
		}
		key_vec = SortUtils.quickSort(key_vec);
		Vector v = new Vector();
		for (int i=0; i<key_vec.size(); i++) {
			String s = (String) key_vec.elementAt(i);
			v.add((String) hmap.get(s));
		}
		return v;
	}

    //KLO, 052909
	private ArrayList removeRedundantRelationships(ArrayList associationList, String rel) {
		ArrayList a = new ArrayList();
		HashSet target_set = new HashSet();
		for (int i=0; i<associationList.size(); i++) {
			String s = (String) associationList.get(i);
			Vector<String> w = parseData(s, "|");
			String associationName = w.elementAt(0);
			if (associationName.compareTo(rel) != 0) {
				String associationTargetCode = w.elementAt(2);
				target_set.add(associationTargetCode);
			}
		}
		for (int i=0; i<associationList.size(); i++) {
			String s = (String) associationList.get(i);
			Vector<String> w = parseData(s, "|");
			String associationName = w.elementAt(0);
			if (associationName.compareTo(rel) != 0) {
				a.add(s);
			} else {
				String associationTargetCode = w.elementAt(2);
				if (!target_set.contains(associationTargetCode)) {
					a.add(s);
				}
			}
		}
        return a;
	}


    public static Vector sortRelationshipData(Vector relationships, String sortBy) {
        DYEE.header();
        DYEE.printMethod();
        DYEE.printList("relationships", relationships);
        DYEE.printVar("sortBy", sortBy);
        if (sortBy == null) sortBy = "name";
		HashMap hmap = new HashMap();
		Vector key_vec = new Vector();
		String delim = "  ";
        for (int n=0; n<relationships.size(); n++)
        {
            String s = (String) relationships.elementAt(n);
            Vector ret_vec = DataUtils.parseData(s, "|");
	        String relationship_name = (String) ret_vec.elementAt(0);
	        String target_concept_name = (String) ret_vec.elementAt(1);
	        String target_concept_code = (String) ret_vec.elementAt(2);
	        String rel_sab = (String) ret_vec.elementAt(3);

            String key = target_concept_name + delim
                       + relationship_name + delim
                       + target_concept_code + delim
                       + rel_sab;
            if (sortBy.compareTo("source") == 0) {
                   key = rel_sab + delim
                       + target_concept_name + delim
                       + relationship_name + delim
                       + target_concept_code;
		    } else if (sortBy.compareTo("rela") == 0) {
                  key = relationship_name + delim
                       + target_concept_name + delim
                       + target_concept_code + delim
                       + rel_sab;
		    } else if (sortBy.compareTo("code") == 0) {
                  key = target_concept_code + delim
                       + target_concept_name + delim
                       + relationship_name + delim
                       + rel_sab;
			}

            hmap.put(key, s);
            key_vec.add(key);
		}
		key_vec = SortUtils.quickSort(key_vec);
		Vector v = new Vector();
		for (int i=0; i<key_vec.size(); i++) {
			String s = (String) key_vec.elementAt(i);
			v.add((String) hmap.get(s));
		}
		return v;
	}


	public HashMap getAssociationTargetHashMap(String scheme, String version, String code, Vector sort_option) {
        Vector parent_asso_vec = new Vector(Arrays.asList(hierAssocToParentNodes_));
        Vector child_asso_vec = new Vector(Arrays.asList(hierAssocToChildNodes_));
        Vector sibling_asso_vec = new Vector(Arrays.asList(assocToSiblingNodes_));
        Vector bt_vec = new Vector(Arrays.asList(assocToBTNodes_));
        Vector nt_vec = new Vector(Arrays.asList(assocToNTNodes_));
        Vector category_vec = new Vector(Arrays.asList(relationshipCategories_));

        HashMap rel_hmap = new HashMap();
		for (int k=0; k<category_vec.size(); k++) {
			String  category = (String) category_vec.elementAt(k);
			Vector vec =  new Vector();
			rel_hmap.put(category, vec);
		}

		Vector w = new Vector();
		HashSet hset = new HashSet();

		Utils.StopWatch stopWatch = new Utils.StopWatch();
		long ms = System.currentTimeMillis();
		String action = "Retrieving all relationships from the server";
		// Retrieve all relationships from the server (a HashMap with key: associationName, value: vector<AssociatedConcept>)
		HashMap hmap = getAssociatedConceptsHashMap(scheme, version, code, null);
		Debug.println("Run time (ms) for " + action + " " + (System.currentTimeMillis() - ms));
        DBG.debugDetails("* " + action + ": " + stopWatch.getResult() + " [getAssociationTargetHashMap]");
        DBG.debugTabbedValue(action, stopWatch.formatInSec());

		Set keyset = hmap.keySet();
		Iterator it = keyset.iterator();

		// Categorize relationships into six categories and find association source data
		stopWatch.start();
		ms = System.currentTimeMillis();
		action = "Categorizing relationships into six categories; finding source data for each relationship";
		while (it.hasNext())
		{
			String rel = (String) it.next();
			String category = "Other";
			if (parent_asso_vec.contains(rel)) category = "Parent";
			else if (child_asso_vec.contains(rel)) category = "Child";
			else if (bt_vec.contains(rel)) category = "Broader";
			else if (nt_vec.contains(rel)) category = "Narrower";
			else if (sibling_asso_vec.contains(rel)) category = "Sibling";
			Vector v = (Vector) hmap.get(rel);

			for (int i=0; i<v.size(); i++) {
				AssociatedConcept ac = (AssociatedConcept) v.elementAt(i);
				EntityDescription ed = ac.getEntityDescription();
				Concept c = ac.getReferencedEntry();
                String source = "unspecified";
				for (NameAndValue qualifier : ac.getAssociationQualifiers().getNameAndValue()) {
					if ("Source".equalsIgnoreCase(qualifier.getContent())) {
						source = qualifier.getName();
						w = (Vector) rel_hmap.get(category);
						if (w == null) {
							w = new Vector();
						}
						String str = rel + "|" + c.getEntityDescription().getContent() + "|" + c.getEntityCode() + "|" + source;
						if (!w.contains(str)) {
							w.add(str);
						    rel_hmap.put(category, w);
						}
					}
				}
			}
		}
		Debug.println("Run time (ms) for " + action + " " + (System.currentTimeMillis() - ms));
        DBG.debugDetails("* " + action + ": " + stopWatch.getResult() + " [getAssociationTargetHashMap]");
        DBG.debugTabbedValue(action, stopWatch.formatInSec());

		// Remove redundant RO relationships
        stopWatch.start();
		ms = System.currentTimeMillis();
		action = "Removing redundant RO relationships";

		HashSet other_hset = new HashSet();
		Vector w2 = (Vector) rel_hmap.get("Other");
		for (int k=0; k<w2.size(); k++) {
			String s = (String) w2.elementAt(k);
			Vector ret_vec = DataUtils.parseData(s, "|");
			String rel = (String) ret_vec.elementAt(0);
			String name = (String) ret_vec.elementAt(1);
			String target_code = (String) ret_vec.elementAt(2);
			String src = (String) ret_vec.elementAt(3);
			String t = name + "|" + target_code + "|" + src;
			if (rel.compareTo("RO") != 0 && !other_hset.contains(t)) {
				other_hset.add(t);
			}
		}
		Vector w3 = new Vector();
		for (int k=0; k<w2.size(); k++) {
			String s = (String) w2.elementAt(k);
			Vector ret_vec = DataUtils.parseData(s, "|");
			String rel = (String) ret_vec.elementAt(0);
			String name = (String) ret_vec.elementAt(1);
			String target_code = (String) ret_vec.elementAt(2);
			String src = (String) ret_vec.elementAt(3);
			if (rel.compareTo("RO") != 0) {
				w3.add(s);
			} else { //RO
				String t = name + "|" + target_code + "|" + src;
				if (!other_hset.contains(t)) {
					w3.add(s);
				}
			}
		}
		rel_hmap.put("Other", w3);
		Debug.println("Run time (ms) for " + action + " " + (System.currentTimeMillis() - ms));
        DBG.debugDetails("* " + action + ": " + stopWatch.getResult() + " [getAssociationTargetHashMap]");
        DBG.debugTabbedValue(action, stopWatch.formatInSec());

        stopWatch.start();
        ms = System.currentTimeMillis();
        action = "Sorting relationships by sort options (columns)";

        // Sort relationships by sort options (columns)
        if (sort_option == null) {
			for (int k=0; k<category_vec.size(); k++) {
				String  category = (String) category_vec.elementAt(k);
				w =  (Vector) rel_hmap.get(category);
				SortUtils.quickSort(w);
				rel_hmap.put(category, w);
			}
		} else {
			for (int k=0; k<category_vec.size(); k++) {
				String  category = (String) category_vec.elementAt(k);
				w =  (Vector) rel_hmap.get(category);
				String sortOption = (String) sort_option.elementAt(k);
				//SortUtils.quickSort(w);
				w = sortRelationshipData(w, sortOption);
				rel_hmap.put(category, w);
			}
		}
		Debug.println("Run time (ms) for " + action + " " + (System.currentTimeMillis() - ms));
        DBG.debugDetails("* " + action + ": " + stopWatch.getResult() + " [getAssociationTargetHashMap]");
        DBG.debugTabbedValue(action, stopWatch.formatInSec());
		return rel_hmap;
	}


	public HashMap getAssociationTargetHashMap(String scheme, String version, String code) {
		return getAssociationTargetHashMap(scheme, version, code, null);
    }
}
