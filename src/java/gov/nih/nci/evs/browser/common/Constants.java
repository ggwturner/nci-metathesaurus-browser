package gov.nih.nci.evs.browser.common;

import java.util.Arrays;
import java.util.List;

/**
 * Application constants class
 * @author garciawa2
 */
public class Constants {

    // Application version
    static public final int MAJOR_VER = 1;
    static public final int MINOR_VER = 0;
    static public final String CONFIG_FILE = "NCImBrowserProperties.xml";
    static public final String CODING_SCHEME_NAME = "NCI MetaThesaurus";

    // Application error constants
    static public final String INIT_PARAM_ERROR_PAGE = "errorPage";
    static public final String ERROR_MESSAGE = "systemMessage";
    static public final String ERROR_UNEXPECTED = "Warning: An unexpected processing error has occurred.";

    // Application constants
    static public final String NA = "N/A";
    static public final String TRUE = "true";
    static public final String FALSE = "false";
    static public final String EMPTY = "";

    static public final int DEFAULT_PAGE_SIZE = 50;

    static public final List<String> REL = Arrays.asList(new String[] {
            "Parent\tPAR\tConcept subsumes current concept as a subtype, part, or otherwise.",
            "Child\tCHD\tConcept is subsumed by current concept as its subtype, part, or otherwise.",
            "Broader\tRB\tConcept is broader than current concept in some less specific way.",
            "Narrower\tRN\tConcept is narrower than current concept in some less specific way.",
            "Sibling\tSIB\tConcept is subsumed by a parent shared with the current concept.",
            "Other\tAQ\tConcept is an allowable qualifier of the current concept.",
            "Other\tQB\tConcept is qualified by the current concept.",
            "Other\tRO\tConcept is related in some other way.",
            "Other\tRQ\tConcept is related and possibly synonymous with the current concept.",
            "Other\tSY\tConcept is synonymous with the current concept."
        });

    static public final List<String> RELA = Arrays.asList(new String[] {
            "Parent\tPAR\t[none]",
            "Parent\tPAR\tcontains",
            "Parent\tPAR\thas_branch",
            "Parent\tPAR\thas_part",
            "Parent\tPAR\thas_regional_part",
            "Parent\tPAR\thas_segment",
            "Parent\tPAR\thas_tributary",
            "Parent\tPAR\tinverse_isa",
            "Child\tCHD\t[none]",
            "Child\tCHD\tbranch_of",
            "Child\tCHD\tcontained_in",
            "Child\tCHD\tisa",
            "Child\tCHD\tpart_of",
            "Child\tCHD\tregional_part_of",
            "Child\tCHD\tsegment_of",
            "Child\tCHD\ttributary_of",
            "Broader\tRB\t[none]",
            "Broader\tRB\tHas_Conceptual_Part",
            "Broader\tRB\thas_conceptual_part",
            "Broader\tRB\thas_form",
            "Broader\tRB\thas_part",
            "Broader\tRB\thas_tradename",
            "Broader\tRB\thas_version",
            "Broader\tRB\tinverse_isa",
            "Broader\tRB\tmapped_from",
            "Broader\tRB\tprecise_ingredient_of",
            "Narrower\tRN\t[none]",
            "Narrower\tRN\tConceptual_Part_Of",
            "Narrower\tRN\tconceptual_part_of",
            "Narrower\tRN\tform_of",
            "Narrower\tRN\thas_precise_ingredient",
            "Narrower\tRN\tisa",
            "Narrower\tRN\tmapped_to",
            "Narrower\tRN\tpart_of",
            "Narrower\tRN\ttradename_of",
            "Narrower\tRN\tversion_of",
            "Sibling\tSIB\t[none]",
            "Sibling\tSIB\tsib_in_branch_of",
            "Sibling\tSIB\tsib_in_isa",
            "Sibling\tSIB\tsib_in_part_of",
            "Sibling\tSIB\tsib_in_tributary_of",
            "Other\tAQ\t[none]",
            "Other\tQB\t[none]",
            "Other\tRO\t[none]",
            "Other\tRO\t3_UTR_of",
            "Other\tRO\t5_UTR_of",
            "Other\tRO\tAbnormal_Cell_Affected_By_Chemical_Or_Drug",
            "Other\tRO\tAbnormality_Associated_With_Allele",
            "Other\tRO\taccess_device_used_by",
            "Other\tRO\taccess_of",
            "Other\tRO\taction_of",
            "Other\tRO\tactive_ingredient_of",
            "Other\tRO\tActivity_Of_Allele",
            "Other\tRO\tAllele_Absent_From_Wild-type_Chromosomal_Location",
            "Other\tRO\tAllele_Associated_With_Disease",
            "Other\tRO\tAllele_Has_Abnormality",
            "Other\tRO\tAllele_Has_Activity",
            "Other\tRO\tAllele_In_Chromosomal_Location",
            "Other\tRO\tAllele_Not_Associated_With_Disease",
            "Other\tRO\tAllele_of",
            "Other\tRO\tAllele_Plays_Altered_Role_In_Process",
            "Other\tRO\tAllele_Plays_Role_In_Metabolism_Of_Chemical_Or_Drug",
            "Other\tRO\tallelic_variant_of",
            "Other\tRO\tAmino_Acid_Variant_of",
            "Other\tRO\tanalyzed_by",
            "Other\tRO\tanalyzes",
            "Other\tRO\tAnatomic_Structure_Has_Location",
            "Other\tRO\tAnatomic_Structure_Is_Physical_Part_Of",
            "Other\tRO\tAnatomy_Originated_From_Biological_Process",
            "Other\tRO\tAneuploidy_Addition_of",
            "Other\tRO\tAneuploidy_Deletion_of",
            "Other\tRO\tapproach_of",
            "Other\tRO\tArm_Location_of",
            "Other\tRO\tArm_of",
            "Other\tRO\tassociated_disease",
            "Other\tRO\tassociated_finding_of",
            "Other\tRO\tassociated_genetic_condition",
            "Other\tRO\tassociated_morphology_of",
            "Other\tRO\tassociated_procedure_of",
            "Other\tRO\tassociated_with",
            "Other\tRO\tAssociated_With_Malfunction_Of_Gene_Product",
            "Other\tRO\tBand_Location_of",
            "Other\tRO\tBand_of",
            "Other\tRO\tBiological_Process_Has_Associated_Location",
            "Other\tRO\tBiological_Process_Has_Initiator_Chemical_Or_Drug",
            "Other\tRO\tBiological_Process_Has_Initiator_Process",
            "Other\tRO\tBiological_Process_Has_Result_Anatomy",
            "Other\tRO\tBiological_Process_Has_Result_Biological_Process",
            "Other\tRO\tBiological_Process_Has_Result_Chemical_Or_Drug",
            "Other\tRO\tBiological_Process_Involves_Chemical_Or_Drug",
            "Other\tRO\tBiological_Process_Involves_Gene_Product",
            "Other\tRO\tBiological_Process_Is_Part_Of_Process",
            "Other\tRO\tBiological_Process_Results_From_Biological_Process",
            "Other\tRO\tBiomarker_Type_Includes_Gene",
            "Other\tRO\tBiomarker_Type_Includes_Gene_Product",
            "Other\tRO\tbranch_of",
            "Other\tRO\tcausative_agent_of",
            "Other\tRO\tcause_of",
            "Other\tRO\tCell_Type_Is_Associated_With_EO_Disease",
            "Other\tRO\tCell_Type_Or_Tissue_Affected_By_Chemical_Or_Drug",
            "Other\tRO\tCentromere_of",
            "Other\tRO\tCH3_Status_of",
            "Other\tRO\tChemical_Or_Drug_Affects_Abnormal_Cell",
            "Other\tRO\tChemical_Or_Drug_Affects_Cell_Type_Or_Tissue",
            "Other\tRO\tChemical_Or_Drug_Affects_Gene_Product",
            "Other\tRO\tChemical_Or_Drug_Has_Mechanism_Of_Action",
            "Other\tRO\tChemical_Or_Drug_Has_Physiologic_Effect",
            "Other\tRO\tChemical_Or_Drug_Initiates_Biological_Process",
            "Other\tRO\tChemical_Or_Drug_Is_Metabolized_By_Enzyme",
            "Other\tRO\tChemical_Or_Drug_Is_Product_Of_Biological_Process",
            "Other\tRO\tChemical_Or_Drug_Metabolism_Is_Associated_With_Allele",
            "Other\tRO\tChemical_Or_Drug_Plays_Role_In_Biological_Process",
            "Other\tRO\tChemotherapy_Regimen_Has_Component",
            "Other\tRO\tChromosomal_Location_of",
            "Other\tRO\tChromosomal_Location_Of_Allele",
            "Other\tRO\tChromosomal_Location_of_Wild-type_Gene",
            "Other\tRO\tChromosomal_Structural_Variant",
            "Other\tRO\tclinical_course_of",
            "Other\tRO\tCompletely_Excised_Anatomy_Has_Procedure",
            "Other\tRO\tCompletely_Excised_Anatomy_May_Have_Procedure",
            "Other\tRO\tComplex_Has_Physical_Part",
            "Other\tRO\tcomponent_of",
            "Other\tRO\tConcept_In_Subset",
            "Other\tRO\tconsists_of",
            "Other\tRO\tConstituent_Amino_Acid_of",
            "Other\tRO\tConstituent_Element_of",
            "Other\tRO\tConstituent_Protein_of",
            "Other\tRO\tConstituent_Variant_of",
            "Other\tRO\tconstitutes",
            "Other\tRO\tcontinuous_with",
            "Other\tRO\tcontraindicated_with",
            "Other\tRO\tdefinitional_manifestation_of",
            "Other\tRO\tdegree_of",
            "Other\tRO\tDeleted_Region_End_Band",
            "Other\tRO\tDeleted_Region_Start_Band",
            "Other\tRO\tdevice_used_by",
            "Other\tRO\tdiagnosed_by",
            "Other\tRO\tdiagnoses",
            "Other\tRO\tdirect_device_of",
            "Other\tRO\tdirect_morphology_of",
            "Other\tRO\tdirect_procedure_site_of",
            "Other\tRO\tdirect_substance_of",
            "Other\tRO\tDisease_Associated_With_Allele",
            "Other\tRO\tDisease_Excludes_Abnormal_Cell",
            "Other\tRO\tDisease_Excludes_Cytogenetic_Abnormality",
            "Other\tRO\tDisease_Excludes_Finding",
            "Other\tRO\tDisease_Excludes_Molecular_Abnormality",
            "Other\tRO\tDisease_Excludes_Normal_Cell_Origin",
            "Other\tRO\tDisease_Excludes_Normal_Tissue_Origin",
            "Other\tRO\tDisease_Excludes_Primary_Anatomic_Site",
            "Other\tRO\tDisease_Has_Abnormal_Cell",
            "Other\tRO\tDisease_Has_Accepted_Treatment_With_Regimen",
            "Other\tRO\tDisease_Has_Associated_Anatomic_Site",
            "Other\tRO\tDisease_Has_Associated_Disease",
            "Other\tRO\tDisease_Has_Associated_Gene",
            "Other\tRO\tDisease_Has_Cytogenetic_Abnormality",
            "Other\tRO\tDisease_Has_Finding",
            "Other\tRO\tDisease_Has_Metastatic_Anatomic_Site",
            "Other\tRO\tDisease_Has_Molecular_Abnormality",
            "Other\tRO\tDisease_Has_Normal_Cell_Origin",
            "Other\tRO\tDisease_Has_Normal_Tissue_Origin",
            "Other\tRO\tDisease_Has_Primary_Anatomic_Site",
            "Other\tRO\tDisease_Is_Grade",
            "Other\tRO\tDisease_Is_Marked_By_Gene",
            "Other\tRO\tDisease_Is_Stage",
            "Other\tRO\tDisease_May_Have_Abnormal_Cell",
            "Other\tRO\tDisease_May_Have_Associated_Disease",
            "Other\tRO\tDisease_May_Have_Cytogenetic_Abnormality",
            "Other\tRO\tDisease_May_Have_Finding",
            "Other\tRO\tDisease_May_Have_Molecular_Abnormality",
            "Other\tRO\tDisease_May_Have_Normal_Cell_Origin",
            "Other\tRO\tDisease_Not_Associated_With_Allele",
            "Other\tRO\tdomain_of",
            "Other\tRO\tdose_form_of",
            "Other\tRO\tdrug_contraindicated_for",
            "Other\tRO\tdue_to",
            "Other\tRO\tDuplicated_Region_End_Band",
            "Other\tRO\tDuplicated_Region_Start_Band",
            "Other\tRO\tEffect_of",
            "Other\tRO\tEncoded_by",
            "Other\tRO\tEncodes",
            "Other\tRO\tEndogenous_Product_Related_To",
            "Other\tRO\tenergy_used_by",
            "Other\tRO\tentry_combination_of",
            "Other\tRO\tEnzyme_Metabolizes_Chemical_Or_Drug",
            "Other\tRO\tEO_Anatomy_Is_Associated_With_EO_Disease",
            "Other\tRO\tEO_Disease_Has_Associated_Cell_Type",
            "Other\tRO\tEO_Disease_Has_Associated_EO_Anatomy",
            "Other\tRO\tEO_Disease_Has_Property_Or_Attribute",
            "Other\tRO\tEO_Disease_Maps_To_Human_Disease",
            "Other\tRO\tepisodicity_of",
            "Other\tRO\tevaluation_of",
            "Other\tRO\tExcised_Anatomy_Has_Procedure",
            "Other\tRO\tExcised_Anatomy_May_Have_Procedure",
            "Other\tRO\texhibited_by",
            "Other\tRO\texhibits",
            "Other\tRO\tExon_of",
            "Other\tRO\tFeature_of",
            "Other\tRO\tfinding_context_of",
            "Other\tRO\tfinding_informer_of",
            "Other\tRO\tfinding_method_of",
            "Other\tRO\tfinding_site_of",
            "Other\tRO\tfocus_of",
            "Other\tRO\tGene_Associated_With_Disease",
            "Other\tRO\tGene_Encodes_Gene_Product",
            "Other\tRO\tGene_Found_In_Organism",
            "Other\tRO\tGene_Has_Abnormality",
            "Other\tRO\tGene_Has_Physical_Location",
            "Other\tRO\tGene_In_Chromosomal_Location",
            "Other\tRO\tGene_Is_Biomarker_Of",
            "Other\tRO\tGene_Is_Biomarker_Type",
            "Other\tRO\tGene_Is_Element_In_Pathway",
            "Other\tRO\tGene_Location_of",
            "Other\tRO\tGene_of",
            "Other\tRO\tGene_Plays_Role_In_Process",
            "Other\tRO\tGene_Product_Affected_By_Chemical_Or_Drug",
            "Other\tRO\tGene_Product_Encoded_By_Gene",
            "Other\tRO\tGene_Product_Expressed_In_Tissue",
            "Other\tRO\tGene_Product_Has_Abnormality",
            "Other\tRO\tGene_Product_Has_Associated_Anatomy",
            "Other\tRO\tGene_Product_Has_Biochemical_Function",
            "Other\tRO\tGene_Product_Has_Chemical_Classification",
            "Other\tRO\tGene_Product_Has_Malfunction_Type",
            "Other\tRO\tGene_Product_Has_Organism_Source",
            "Other\tRO\tGene_Product_Has_Structural_Domain_Or_Motif",
            "Other\tRO\tGene_Product_Is_Biomarker_Of",
            "Other\tRO\tGene_Product_Is_Biomarker_Type",
            "Other\tRO\tGene_Product_Is_Element_In_Pathway",
            "Other\tRO\tGene_Product_Is_Physical_Part_Of",
            "Other\tRO\tGene_Product_Malfunction_Associated_With_Disease",
            "Other\tRO\tGene_Product_Plays_Role_In_Biological_Process",
            "Other\tRO\tGenomic_Mutation_Of",
            "Other\tRO\tHas_3_UTR",
            "Other\tRO\tHas_5_UTR",
            "Other\tRO\thas_access",
            "Other\tRO\thas_action",
            "Other\tRO\thas_active_ingredient",
            "Other\tRO\thas_additive",
            "Other\tRO\thas_affiliation",
            "Other\tRO\tHas_Allele",
            "Other\tRO\thas_allelic_variant",
            "Other\tRO\tHas_Amino_Acid_Variant",
            "Other\tRO\tHas_Aneuploidy_Addition",
            "Other\tRO\tHas_Aneuploidy_Deletion",
            "Other\tRO\thas_approach",
            "Other\tRO\tHas_Arm",
            "Other\tRO\tHas_Arm_Location",
            "Other\tRO\thas_associated_finding",
            "Other\tRO\thas_associated_morphology",
            "Other\tRO\thas_associated_procedure",
            "Other\tRO\thas_atmospheric_component",
            "Other\tRO\tHas_Band",
            "Other\tRO\tHas_Band_Location",
            "Other\tRO\thas_been_treated",
            "Other\tRO\thas_bioassay_data",
            "Other\tRO\thas_bioassays",
            "Other\tRO\thas_biomaterial_characteristics",
            "Other\tRO\thas_branch",
            "Other\tRO\thas_cancer_site",
            "Other\tRO\thas_category",
            "Other\tRO\thas_causative_agent",
            "Other\tRO\tHas_Centromere",
            "Other\tRO\tHas_CH3_Status",
            "Other\tRO\thas_chromosomal_aberration_classification",
            "Other\tRO\tHas_Chromosomal_Location",
            "Other\tRO\thas_citation",
            "Other\tRO\thas_clinical_course",
            "Other\tRO\thas_clinical_finding",
            "Other\tRO\thas_clinical_record",
            "Other\tRO\thas_clinical_treatment",
            "Other\tRO\thas_component",
            "Other\tRO\thas_compound",
            "Other\tRO\tHas_Constituent_Amino_Acid",
            "Other\tRO\tHas_Constituent_Element",
            "Other\tRO\tHas_Constituent_Protein",
            "Other\tRO\tHas_Constituent_Variant",
            "Other\tRO\thas_contraindicated_drug",
            "Other\tRO\thas_contraindication",
            "Other\tRO\thas_cubic_volume",
            "Other\tRO\thas_database",
            "Other\tRO\thas_database_entry_type",
            "Other\tRO\thas_definitional_manifestation",
            "Other\tRO\thas_degree",
            "Other\tRO\thas_diameter",
            "Other\tRO\thas_direct_device",
            "Other\tRO\thas_direct_morphology",
            "Other\tRO\thas_direct_procedure_site",
            "Other\tRO\thas_direct_substance",
            "Other\tRO\thas_disease_location",
            "Other\tRO\thas_disease_staging",
            "Other\tRO\thas_disease_state",
            "Other\tRO\thas_domain",
            "Other\tRO\thas_donor",
            "Other\tRO\thas_dose_form",
            "Other\tRO\tHas_Effect",
            "Other\tRO\thas_entry_combination",
            "Other\tRO\thas_episodicity",
            "Other\tRO\thas_evaluation",
            "Other\tRO\tHas_Exon",
            "Other\tRO\thas_experiment_design",
            "Other\tRO\thas_experiment_design_type",
            "Other\tRO\thas_experiment_factors",
            "Other\tRO\thas_factor_value",
            "Other\tRO\thas_factor_value_ontology_entry",
            "Other\tRO\thas_family_member",
            "Other\tRO\thas_family_relationship",
            "Other\tRO\tHas_Feature",
            "Other\tRO\thas_feature_shape",
            "Other\tRO\thas_fiducials",
            "Other\tRO\thas_finding_context",
            "Other\tRO\thas_finding_informer",
            "Other\tRO\thas_finding_method",
            "Other\tRO\thas_finding_site",
            "Other\tRO\thas_focus",
            "Other\tRO\tHas_Free_Acid_Or_Base_Form",
            "Other\tRO\tHas_Gene",
            "Other\tRO\tHas_Gene_Location",
            "Other\tRO\tHas_Gene_Product_Element",
            "Other\tRO\tHas_Genomic_Mutation",
            "Other\tRO\thas_hardware",
            "Other\tRO\thas_height",
            "Other\tRO\thas_host",
            "Other\tRO\thas_host_part",
            "Other\tRO\thas_image_format",
            "Other\tRO\thas_indirect_device",
            "Other\tRO\thas_indirect_morphology",
            "Other\tRO\thas_indirect_procedure_site",
            "Other\tRO\thas_individual",
            "Other\tRO\thas_individual_genetic_characteristics",
            "Other\tRO\thas_ingredient",
            "Other\tRO\thas_inheritance_type",
            "Other\tRO\thas_initial_time_point",
            "Other\tRO\thas_intent",
            "Other\tRO\thas_interpretation",
            "Other\tRO\tHas_Intron",
            "Other\tRO\thas_laterality",
            "Other\tRO\thas_length",
            "Other\tRO\tHas_Location",
            "Other\tRO\thas_location",
            "Other\tRO\thas_MAGE_description",
            "Other\tRO\thas_manifestation",
            "Other\tRO\thas_manufacturer",
            "Other\tRO\thas_mass",
            "Other\tRO\tHas_Maternal_Uniparental_Disomy",
            "Other\tRO\thas_maximum_measurement",
            "Other\tRO\thas_measurement",
            "Other\tRO\thas_measurement_method",
            "Other\tRO\thas_measurement_type",
            "Other\tRO\thas_mechanism_of_action",
            "Other\tRO\thas_member",
            "Other\tRO\thas_method",
            "Other\tRO\tHas_Mode_of_Inheritance",
            "Other\tRO\thas_node_value",
            "Other\tRO\thas_node_value_type",
            "Other\tRO\thas_nodes",
            "Other\tRO\tHas_Nucleotide_Repeat",
            "Other\tRO\tHas_Nucleotide_Variant",
            "Other\tRO\thas_nutrient_component",
            "Other\tRO\thas_occurrence",
            "Other\tRO\thas_organism_part",
            "Other\tRO\thas_owner",
            "Other\tRO\thas_parent_organization",
            "Other\tRO\thas_part_modified",
            "Other\tRO\tHas_Paternal_Uniparental_Disomy",
            "Other\tRO\thas_pathological_process",
            "Other\tRO\thas_performer",
            "Other\tRO\thas_pharmacokinetics",
            "Other\tRO\tHas_Physical_Part_Of_Anatomic_Structure",
            "Other\tRO\thas_physiologic_effect",
            "Other\tRO\thas_precise_ingredient",
            "Other\tRO\thas_prior_disease_state",
            "Other\tRO\thas_priority",
            "Other\tRO\thas_procedure_context",
            "Other\tRO\thas_procedure_device",
            "Other\tRO\thas_procedure_morphology",
            "Other\tRO\thas_procedure_site",
            "Other\tRO\thas_property",
            "Other\tRO\thas_property_set",
            "Other\tRO\thas_protocol",
            "Other\tRO\thas_providers",
            "Other\tRO\thas_reason_for_deprecation",
            "Other\tRO\thas_recipient_category",
            "Other\tRO\thas_result",
            "Other\tRO\thas_revision_status",
            "Other\tRO\thas_route_of_administration",
            "Other\tRO\tHas_RT_Product",
            "Other\tRO\tHas_Salt_Form",
            "Other\tRO\thas_scale",
            "Other\tRO\thas_scale_type",
            "Other\tRO\tHas_Segment",
            "Other\tRO\thas_severity",
            "Other\tRO\thas_software",
            "Other\tRO\thas_species",
            "Other\tRO\thas_specimen",
            "Other\tRO\thas_specimen_procedure",
            "Other\tRO\thas_specimen_source_identity",
            "Other\tRO\thas_specimen_source_morphology",
            "Other\tRO\thas_specimen_source_topography",
            "Other\tRO\thas_specimen_substance",
            "Other\tRO\thas_subject_relationship_context",
            "Other\tRO\tHas_Target",
            "Other\tRO\tHas_Telomere",
            "Other\tRO\thas_temporal_context",
            "Other\tRO\thas_test_result",
            "Other\tRO\thas_test_type",
            "Other\tRO\thas_time_aspect",
            "Other\tRO\tHas_Transcript",
            "Other\tRO\thas_treatment",
            "Other\tRO\thas_tributary",
            "Other\tRO\thas_type",
            "Other\tRO\thas_units",
            "Other\tRO\thas_URI",
            "Other\tRO\thas_value",
            "Other\tRO\tHuman_Disease_Maps_To_EO_Disease",
            "Other\tRO\tHuman_Sex_Determinant",
            "Other\tRO\tImaged_Anatomy_Has_Procedure",
            "Other\tRO\tincluded_in",
            "Other\tRO\tincludes",
            "Other\tRO\tindirect_device_of",
            "Other\tRO\tindirect_morphology_of",
            "Other\tRO\tindirect_procedure_site_of",
            "Other\tRO\tinduced_by",
            "Other\tRO\tinduces",
            "Other\tRO\tingredient_of",
            "Other\tRO\tinheritance_type_of",
            "Other\tRO\tintent_of",
            "Other\tRO\tinterpretation_of",
            "Other\tRO\tinterprets",
            "Other\tRO\tIntron_of",
            "Other\tRO\tINV_Chromosomal_Structural_Variant",
            "Other\tRO\tINV_Deleted_Region_End_Band",
            "Other\tRO\tINV_Deleted_Region_Start_Band",
            "Other\tRO\tINV_Duplicated_Region_End_Band",
            "Other\tRO\tINV_Duplicated_Region_Start_Band",
            "Other\tRO\tINV_Human_Sex_Determinant",
            "Other\tRO\tINV_Inverted_Region_End_Band",
            "Other\tRO\tINV_Inverted_Region_End_Exon",
            "Other\tRO\tINV_Inverted_Region_End_Gene",
            "Other\tRO\tINV_Inverted_Region_End_UTR",
            "Other\tRO\tINV_Inverted_Region_Start_Band",
            "Other\tRO\tINV_Inverted_Region_Start_Exon",
            "Other\tRO\tINV_Inverted_Region_Start_Gene",
            "Other\tRO\tINV_Inverted_Region_Start_Intron",
            "Other\tRO\tINV_Involves",
            "Other\tRO\tINV_Isochromosome_Origin",
            "Other\tRO\tINV_Karyotype_Class",
            "Other\tRO\tINV_Source_Band",
            "Other\tRO\tINV_Source_Exon",
            "Other\tRO\tINV_Source_Gene",
            "Other\tRO\tINV_Source_Intron",
            "Other\tRO\tINV_Target_Band",
            "Other\tRO\tINV_Target_Exon",
            "Other\tRO\tINV_Target_Gene",
            "Other\tRO\tINV_Target_Intron",
            "Other\tRO\tinverse_has_additive",
            "Other\tRO\tinverse_has_affiliation",
            "Other\tRO\tinverse_has_atmospheric_component",
            "Other\tRO\tinverse_has_been_treated",
            "Other\tRO\tinverse_has_bioassay_data",
            "Other\tRO\tinverse_has_bioassays",
            "Other\tRO\tinverse_has_biomaterial_characteristics",
            "Other\tRO\tinverse_has_cancer_site",
            "Other\tRO\tinverse_has_category",
            "Other\tRO\tinverse_has_chromosomal_aberration_classification",
            "Other\tRO\tinverse_has_citation",
            "Other\tRO\tinverse_has_clinical_finding",
            "Other\tRO\tinverse_has_clinical_record",
            "Other\tRO\tinverse_has_clinical_treatment",
            "Other\tRO\tinverse_has_compound",
            "Other\tRO\tinverse_has_cubic_volume",
            "Other\tRO\tinverse_has_database",
            "Other\tRO\tinverse_has_database_entry_type",
            "Other\tRO\tinverse_has_diameter",
            "Other\tRO\tinverse_has_disease_location",
            "Other\tRO\tinverse_has_disease_staging",
            "Other\tRO\tinverse_has_disease_state",
            "Other\tRO\tinverse_has_donor",
            "Other\tRO\tinverse_has_experiment_design",
            "Other\tRO\tinverse_has_experiment_design_type",
            "Other\tRO\tinverse_has_experiment_factors",
            "Other\tRO\tinverse_has_factor_value",
            "Other\tRO\tinverse_has_factor_value_ontology_entry",
            "Other\tRO\tinverse_has_family_member",
            "Other\tRO\tinverse_has_family_relationship",
            "Other\tRO\tinverse_has_feature_shape",
            "Other\tRO\tinverse_has_fiducials",
            "Other\tRO\tinverse_has_hardware",
            "Other\tRO\tinverse_has_height",
            "Other\tRO\tinverse_has_host",
            "Other\tRO\tinverse_has_host_part",
            "Other\tRO\tinverse_has_image_format",
            "Other\tRO\tinverse_has_individual",
            "Other\tRO\tinverse_has_individual_genetic_characteristics",
            "Other\tRO\tinverse_has_initial_time_point",
            "Other\tRO\tinverse_has_length",
            "Other\tRO\tinverse_has_MAGE_description",
            "Other\tRO\tinverse_has_manufacturer",
            "Other\tRO\tinverse_has_mass",
            "Other\tRO\tinverse_has_maximum_measurement",
            "Other\tRO\tinverse_has_measurement_type",
            "Other\tRO\tinverse_has_node_value",
            "Other\tRO\tinverse_has_node_value_type",
            "Other\tRO\tinverse_has_nodes",
            "Other\tRO\tinverse_has_nutrient_component",
            "Other\tRO\tinverse_has_organism_part",
            "Other\tRO\tinverse_has_owner",
            "Other\tRO\tinverse_has_parent_organization",
            "Other\tRO\tinverse_has_part_modified",
            "Other\tRO\tinverse_has_performer",
            "Other\tRO\tinverse_has_prior_disease_state",
            "Other\tRO\tinverse_has_property_set",
            "Other\tRO\tinverse_has_protocol",
            "Other\tRO\tinverse_has_providers",
            "Other\tRO\tinverse_has_reason_for_deprecation",
            "Other\tRO\tinverse_has_software",
            "Other\tRO\tinverse_has_species",
            "Other\tRO\tinverse_has_test_result",
            "Other\tRO\tinverse_has_test_type",
            "Other\tRO\tinverse_has_treatment",
            "Other\tRO\tinverse_has_type",
            "Other\tRO\tinverse_has_units",
            "Other\tRO\tinverse_has_URI",
            "Other\tRO\tinverse_was_tested_for",
            "Other\tRO\tInverted_Region_End_Band",
            "Other\tRO\tInverted_Region_End_Exon",
            "Other\tRO\tInverted_Region_End_Gene",
            "Other\tRO\tInverted_Region_End_UTR",
            "Other\tRO\tInverted_Region_Start_Band",
            "Other\tRO\tInverted_Region_Start_Exon",
            "Other\tRO\tInverted_Region_Start_Gene",
            "Other\tRO\tInverted_Region_Start_Intron",
            "Other\tRO\tInvolves",
            "Other\tRO\tIs_Abnormal_Cell_Of_Disease",
            "Other\tRO\tIs_Abnormality_Of_Gene",
            "Other\tRO\tIs_Abnormality_Of_Gene_Product",
            "Other\tRO\tIs_Associated_Anatomic_Site_Of",
            "Other\tRO\tIs_Associated_Anatomy_Of_Gene_Product",
            "Other\tRO\tIs_Associated_Disease_Of",
            "Other\tRO\tIs_Biochemical_Function_Of_Gene_Product",
            "Other\tRO\tIs_Chemical_Classification_Of_Gene_Product",
            "Other\tRO\tIs_Chromosomal_Location_Of_Gene",
            "Other\tRO\tIs_Component_Of_Chemotherapy_Regimen",
            "Other\tRO\tIs_Cytogenetic_Abnormality_Of_Disease",
            "Other\tRO\tIs_Finding_Of_Disease",
            "Other\tRO\tIs_Grade_Of_Disease",
            "Other\tRO\tis_interpreted_by",
            "Other\tRO\tIs_Location_Of",
            "Other\tRO\tIs_Location_Of_Anatomic_Structure",
            "Other\tRO\tIs_Location_Of_Biological_Process",
            "Other\tRO\tIs_Malfunction_Type_Of_Gene_Product",
            "Other\tRO\tIs_Marked_By_Gene_Product",
            "Other\tRO\tIs_Mechanism_Of_Action_Of_Chemical_Or_Drug",
            "Other\tRO\tIs_Metastatic_Anatomic_Site_Of_Disease",
            "Other\tRO\tIs_Molecular_Abnormality_Of_Disease",
            "Other\tRO\tIs_Normal_Cell_Origin_Of_Disease",
            "Other\tRO\tIs_Normal_Tissue_Origin_Of_Disease",
            "Other\tRO\tIs_Not_Abnormal_Cell_Of_Disease",
            "Other\tRO\tIs_Not_Cytogenetic_Abnormality_Of_Disease",
            "Other\tRO\tIs_Not_Finding_Of_Disease",
            "Other\tRO\tIs_Not_Molecular_Abnormality_Of_Disease",
            "Other\tRO\tIs_Not_Normal_Cell_Origin_Of_Disease",
            "Other\tRO\tIs_Not_Normal_Tissue_Origin_Of_Disease",
            "Other\tRO\tIs_Not_Primary_Anatomic_Site_Of_Disease",
            "Other\tRO\tIs_Organism_Source_Of_Gene_Product",
            "Other\tRO\tIs_Physical_Location_Of_Gene",
            "Other\tRO\tIs_Physiologic_Effect_Of_Chemical_Or_Drug",
            "Other\tRO\tIs_Primary_Anatomic_Site_Of_Disease",
            "Other\tRO\tIs_Property_Or_Attribute_Of_EO_Disease",
            "Other\tRO\tIs_Qualified_By",
            "Other\tRO\tIs_Related_To_Endogenous_Product",
            "Other\tRO\tIs_Stage_Of_Disease",
            "Other\tRO\tIs_Structural_Domain_Or_Motif_Of_Gene_Product",
            "Other\tRO\tIs_Target_Of_Agent",
            "Other\tRO\tIsochromosome_Origin",
            "Other\tRO\tKaryotype_Class",
            "Other\tRO\tKind_Is_Domain_Of",
            "Other\tRO\tKind_Is_Range_Of",
            "Other\tRO\tlarger_than",
            "Other\tRO\tlaterality_of",
            "Other\tRO\tlocation_of",
            "Other\tRO\tmanifestation_of",
            "Other\tRO\tMaternal_Uniparental_Disomy_of",
            "Other\tRO\tMay_Be_Abnormal_Cell_Of_Disease",
            "Other\tRO\tMay_Be_Associated_Disease_Of_Disease",
            "Other\tRO\tMay_Be_Cytogenetic_Abnormality_Of_Disease",
            "Other\tRO\tmay_be_diagnosed_by",
            "Other\tRO\tMay_Be_Finding_Of_Disease",
            "Other\tRO\tMay_Be_Molecular_Abnormality_Of_Disease",
            "Other\tRO\tMay_Be_Normal_Cell_Origin_Of_Disease",
            "Other\tRO\tmay_be_prevented_by",
            "Other\tRO\tmay_be_treated_by",
            "Other\tRO\tmay_diagnose",
            "Other\tRO\tmay_prevent",
            "Other\tRO\tmay_treat",
            "Other\tRO\tmeasured_by",
            "Other\tRO\tmeasurement_method_of",
            "Other\tRO\tmeasurement_of",
            "Other\tRO\tmeasures",
            "Other\tRO\tmechanism_of_action_of",
            "Other\tRO\tmember_of_cluster",
            "Other\tRO\tmetabolic_site_of",
            "Other\tRO\tmetabolized_by",
            "Other\tRO\tmetabolizes",
            "Other\tRO\tmethod_of",
            "Other\tRO\tMode_of_Inheritance_of",
            "Other\tRO\tNucleotide_Repeat_of",
            "Other\tRO\tNucleotide_Variant_of",
            "Other\tRO\toccurs_after",
            "Other\tRO\toccurs_before",
            "Other\tRO\toccurs_in",
            "Other\tRO\tOrganism_Has_Gene",
            "Other\tRO\tPartially_Excised_Anatomy_Has_Procedure",
            "Other\tRO\tPartially_Excised_Anatomy_May_Have_Procedure",
            "Other\tRO\tPaternal_Uniparental_Disomy_of",
            "Other\tRO\tpathological_process_of",
            "Other\tRO\tPathway_Has_Gene_Element",
            "Other\tRO\tpharmacokinetics_of",
            "Other\tRO\tphysiologic_effect_of",
            "Other\tRO\tprecise_ingredient_of",
            "Other\tRO\tpriority_of",
            "Other\tRO\tprocedure_context_of",
            "Other\tRO\tprocedure_device_of",
            "Other\tRO\tProcedure_Has_Completely_Excised_Anatomy",
            "Other\tRO\tProcedure_Has_Excised_Anatomy",
            "Other\tRO\tProcedure_Has_Imaged_Anatomy",
            "Other\tRO\tProcedure_Has_Partially_Excised_Anatomy",
            "Other\tRO\tProcedure_Has_Target_Anatomy",
            "Other\tRO\tProcedure_May_Have_Completely_Excised_Anatomy",
            "Other\tRO\tProcedure_May_Have_Excised_Anatomy",
            "Other\tRO\tProcedure_May_Have_Partially_Excised_Anatomy",
            "Other\tRO\tprocedure_morphology_of",
            "Other\tRO\tprocedure_site_of",
            "Other\tRO\tProcess_Altered_By_Allele",
            "Other\tRO\tProcess_Includes_Biological_Process",
            "Other\tRO\tProcess_Initiates_Biological_Process",
            "Other\tRO\tProcess_Involves_Gene",
            "Other\tRO\tproperty_of",
            "Other\tRO\tQualifier_Applies_To",
            "Other\tRO\trecipient_category_of",
            "Other\tRO\treformulated_to",
            "Other\tRO\treformulation_of",
            "Other\tRO\tRegimen_Has_Accepted_Use_For_Disease",
            "Other\tRO\trelated_to",
            "Other\tRO\tresult_of",
            "Other\tRO\trevision_status_of",
            "Other\tRO\tRole_Has_Domain",
            "Other\tRO\tRole_Has_Parent",
            "Other\tRO\tRole_Has_Range",
            "Other\tRO\tRole_Is_Parent_Of",
            "Other\tRO\troute_of_administration_of",
            "Other\tRO\tRT_Product_of",
            "Other\tRO\tscale_of",
            "Other\tRO\tscale_type_of",
            "Other\tRO\tSegment_of",
            "Other\tRO\tseverity_of",
            "Other\tRO\tsite_of_metabolism",
            "Other\tRO\tsmaller_than",
            "Other\tRO\tSource_Band",
            "Other\tRO\tSource_Exon",
            "Other\tRO\tSource_Gene",
            "Other\tRO\tSource_Intron",
            "Other\tRO\tspecimen_of",
            "Other\tRO\tspecimen_procedure_of",
            "Other\tRO\tspecimen_source_identity_of",
            "Other\tRO\tspecimen_source_morphology_of",
            "Other\tRO\tspecimen_source_topography_of",
            "Other\tRO\tspecimen_substance_of",
            "Other\tRO\tsubject_relationship_context_of",
            "Other\tRO\tSubset_Includes_Concept",
            "Other\tRO\tsubstance_used_by",
            "Other\tRO\tTarget_Anatomy_Has_Procedure",
            "Other\tRO\tTarget_Band",
            "Other\tRO\tTarget_Exon",
            "Other\tRO\tTarget_Gene",
            "Other\tRO\tTarget_Intron",
            "Other\tRO\tTelomere_of",
            "Other\tRO\ttemporal_context_of",
            "Other\tRO\ttime_aspect_of",
            "Other\tRO\tTissue_Is_Expression_Site_Of_Gene_Product",
            "Other\tRO\tTranscript_of",
            "Other\tRO\ttreated_by",
            "Other\tRO\ttreats",
            "Other\tRO\ttributary_of",
            "Other\tRO\tused_by",
            "Other\tRO\tuses",
            "Other\tRO\tuses_access_device",
            "Other\tRO\tuses_device",
            "Other\tRO\tuses_energy",
            "Other\tRO\tuses_substance",
            "Other\tRO\tvalue_of",
            "Other\tRO\twas_tested_for",
            "Other\tRQ\t[none]",
            "Other\tRQ\talias_of",
            "Other\tRQ\tclassified_as",
            "Other\tRQ\tclassifies",
            "Other\tRQ\tclinically_similar",
            "Other\tRQ\thas_alias",
            "Other\tRQ\thas_outcome",
            "Other\tRQ\tmapped_from",
            "Other\tRQ\tmapped_to",
            "Other\tRQ\toutcome_of",
            "Other\tRQ\tsee",
            "Other\tRQ\tsee_from",
            "Other\tRQ\tuse",
            "Other\tRQ\tused_for",
            "Other\tSY\t[none]",
            "Other\tSY\talias_of",
            "Other\tSY\tbritish_form_of",
            "Other\tSY\tentry_version_of",
            "Other\tSY\texpanded_form_of",
            "Other\tSY\thas_alias",
            "Other\tSY\thas_british_form",
            "Other\tSY\thas_entry_version",
            "Other\tSY\thas_expanded_form",
            "Other\tSY\thas_multi_level_category",
            "Other\tSY\thas_permuted_term",
            "Other\tSY\thas_plain_text_form",
            "Other\tSY\thas_single_level_category",
            "Other\tSY\thas_sort_version",
            "Other\tSY\tmth_british_form_of",
            "Other\tSY\tmth_expanded_form_of",
            "Other\tSY\tmth_has_british_form",
            "Other\tSY\tmth_has_expanded_form",
            "Other\tSY\tmth_has_plain_text_form",
            "Other\tSY\tmth_has_xml_form",
            "Other\tSY\tmth_plain_text_form_of",
            "Other\tSY\tmth_xml_form_of",
            "Other\tSY\tpermuted_term_of",
            "Other\tSY\tplain_text_form_of",
            "Other\tSY\tsort_version_of"
        });

    /**
     * Constructor
     */
    private Constants() {
        // Prevent class from being explicitly instantiated
    }

} // Class Constants